package com.juliaVenichenko.physics.screens.QuantumScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.TextView;

public class QuantumScreen8 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;
    public QuantumScreen8(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text1 = new TextView(myGdxGame.commonRedFont, 280, 400, "СОСТАВ АТОМНОГО ЯДРА");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 290, "Атомное ядро, находящееся в центре атома, в 10 000 раз меньше" + "\n" +
                "размера самого атома и сосредоточивает 99,9% массы атома.");
        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 210, "В состав ядра входят протоны (P) и нейтроны (N).");
        text4 = new TextView(myGdxGame.commonWhiteFont, 30, 100, "Заряд ядра Z - зарядовое число (число протонов в ядре), которое" + "\n" +
                "соответствует номеру элемента в таблице Менделеева.");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
        button_sound = new ButtonView(693, 383, 75, 70, GameResources.BUTTON_SOUND_IMG_PATH);
    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);

        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);
        text3.draw(myGdxGame.batch);
        text4.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);
        button_sound.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen9);
                myGdxGame.audioManager.sound69.stop();
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen7);
                myGdxGame.audioManager.sound69.stop();
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuQuantumScreen);
                myGdxGame.audioManager.sound69.stop();
            }
            if (button_sound.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.audioManager.sound69.play();
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();
        text3.dispose();
        text4.dispose();

        myGdxGame.audioManager.sound69.dispose();

        button_left.dispose();
        button_right.dispose();

        button_back.dispose();
        button_sound.dispose();
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
