package com.juliaVenichenko.physics.screens.ThermalScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.TextView;

public class ThermalScreen1 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;
    private ButtonView button_video;

    private Array<Atom> atoms;
    private Texture atomTexture;
    private Texture rectTexture;
    private float rectX, rectY, rectWidth, rectHeight;
    private float atomSize = 50f;
    private ButtonView clearButton;
    public ThermalScreen1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text1 = new TextView(myGdxGame.commonRedFont, 350, 400, "МОЛЕКУЛЫ");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 270, "Все вещества (жидкие, твёрдые и газообразные) образованы из" + "\n" +
                "мельчайших частиц - молекул, которые сами состоят из атомов" + "\n" + "(элементарных молекул).");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
        button_sound = new ButtonView(693, 383, 75, 70, GameResources.BUTTON_SOUND_IMG_PATH);
        button_video = new ButtonView(615, 383, 75, 70, GameResources.BUTTON_PLAY_IMG_PATH);

        atoms = new Array<>();
        atomTexture = new Texture("atom.png");
        rectTexture = new Texture("rectangle.png");
        clearButton = new ButtonView(570, 80, 200, 100, myGdxGame.commonRedFont,"button.png", "Очистить");

        rectX = 100;
        rectY = 30;
        rectWidth = 470;
        rectHeight = 200;
    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        float deltaTime = Gdx.graphics.getDeltaTime();
        for (Atom atom : atoms) {
            atom.update(deltaTime, rectX, rectY, rectWidth, rectHeight);
        }

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);
        button_sound.draw(myGdxGame.batch);
        button_video.draw(myGdxGame.batch);

        clearButton.draw(myGdxGame.batch);

        myGdxGame.batch.draw(rectTexture, rectX, rectY, rectWidth, rectHeight);

        for (Atom atom : atoms) {
            atom.draw(myGdxGame.batch);
        }

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.thermalScreen2);
                myGdxGame.audioManager.sound34.stop();
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen42);
                myGdxGame.audioManager.sound34.stop();
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuThermalScreen);
                myGdxGame.audioManager.sound34.stop();
            }
            if (button_sound.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.audioManager.sound34.play();
            }
            if (button_video.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.videoThermalScreen1);
            }

            if (isInRect(myGdxGame.touch.x, myGdxGame.touch.y)) {
                Atom clickedAtom = getClickedAtom(myGdxGame.touch.x, myGdxGame.touch.y);
                if (clickedAtom != null) {
                    atoms.removeValue(clickedAtom, true);
                } else {
                    Atom newAtom = new Atom(atomTexture, myGdxGame.touch.x, myGdxGame.touch.y, randomDx(), randomDy(), atomSize);
                    atoms.add(newAtom);

                    myGdxGame.audioManager.unusualClick.play();
                }
            } else if (clearButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                atoms.clear();
            }
        }
    }

    private Atom getClickedAtom(float x, float y) {
        for (Atom atom : atoms) {
            if (isPointInAtom(x, y, atom)) {
                return atom;
            }
        }
        return null;
    }

    private boolean isPointInAtom(float x, float y, Atom atom) {
        float atomX = atom.getX();
        float atomY = atom.getY();
        float radius = atom.getSize() / 2;

        return (x >= atomX - radius && x <= atomX + radius && y >= atomY - radius && y <= atomY + radius);
    }

    private boolean isInRect(float x, float y) {
        return x >= rectX && x <= rectX + rectWidth && y >= rectY && y <= rectY + rectHeight;
    }

    private float randomDx() {
        return MathUtils.random(-100, 100);
    }

    private float randomDy() {
        return MathUtils.random(-100, 100);
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();

        myGdxGame.audioManager.sound34.dispose();
        myGdxGame.audioManager.unusualClick.dispose();

        button_left.dispose();
        button_right.dispose();

        button_back.dispose();
        button_sound.dispose();
        button_video.dispose();

        if (clearButton != null) {
            clearButton.dispose();
        }
        if (rectTexture != null) {
            rectTexture.dispose();
        }

        if (atoms != null) {
            for (Atom atom : atoms) {
                if (atom != null) {
                    atom.dispose();
                }
            }
        }

        if (atomTexture != null) {
            atomTexture.dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
