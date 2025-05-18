package com.mygdx.game.screens.ThermalScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;
import com.mygdx.game.components.TextView;

public class ThermalScreen1 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;

    private Array<Atom> atoms;
    private Texture atomTexture;
    private Texture rectTexture;
    private float rectX, rectY, rectWidth, rectHeight; // границы области
    private float atomSize = 50f; // размер атомов
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

        atoms = new Array<>();
        atomTexture = new Texture("atom.png");
        rectTexture = new Texture("rectangle.png");
        clearButton = new ButtonView(570, 80, 200, 100, myGdxGame.commonRedFont,"button.png", "Очистить");

        // Размер и позиция области
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

        // Обновляем атомы, передавая deltaTime
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

        clearButton.draw(myGdxGame.batch);

        // Рисуем область
        myGdxGame.batch.draw(rectTexture, rectX, rectY, rectWidth, rectHeight);

        // Рисуем атомы
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

            // Проверяем, попадает ли нажатие в прямоугольник
            if (isInRect(myGdxGame.touch.x, myGdxGame.touch.y)) {
                // Проверяем, кликнули ли по какому-либо атому
                Atom clickedAtom = getClickedAtom(myGdxGame.touch.x, myGdxGame.touch.y);
                if (clickedAtom != null) {
                    // Если кликнули по атому, удаляем его
                    atoms.removeValue(clickedAtom, true);
                } else {
                    // Если не кликнули по атому, создаем новый атом
                    Atom newAtom = new Atom(atomTexture, myGdxGame.touch.x, myGdxGame.touch.y, randomDx(), randomDy(), atomSize);
                    atoms.add(newAtom);

                    myGdxGame.audioManager.unusualClick.play();
                }
            } else if (clearButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                // Если нажали на кнопку очистки, очищаем список атомов
                atoms.clear();
            }
        }
    }

    // Метод для проверки, был ли клик по атому
    private Atom getClickedAtom(float x, float y) {
        for (Atom atom : atoms) {
            if (isPointInAtom(x, y, atom)) {
                return atom; // Возвращаем атом, если кликнули по нему
            }
        }
        return null; // Если ни один атом не был найден
    }

    // Метод для проверки, находится ли точка внутри атома
    private boolean isPointInAtom(float x, float y, Atom atom) {
        // Предполагаем, что атом имеет радиус или размер (например, круг)
        float atomX = atom.getX(); // Получаем координату X атома
        float atomY = atom.getY(); // Получаем координату Y атома
        float radius = atom.getSize() / 2; // Предполагаем, что размер атома - это его диаметр

        // Проверяем расстояние до центра атома
        return (x >= atomX - radius && x <= atomX + radius && y >= atomY - radius && y <= atomY + radius);
    }

    // Метод для проверки, находится ли точка внутри прямоугольника
    private boolean isInRect(float x, float y) {
        return x >= rectX && x <= rectX + rectWidth && y >= rectY && y <= rectY + rectHeight;
    }

    // Метод для генерации случайных значений dx и dy
    private float randomDx() {
        return MathUtils.random(-100, 100); // Пример случайного значения для dx
    }

    private float randomDy() {
        return MathUtils.random(-100, 100); // Пример случайного значения для dy
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

        if (clearButton != null) {
            clearButton.dispose();
        }
        if (rectTexture != null) {
            rectTexture.dispose();
        }

        // Освобождаем текстуру атома и вызываем dispose для каждого атома
        if (atoms != null) {
            for (Atom atom : atoms) {
                if (atom != null) {
                    atom.dispose();
                }
            }
        }

        // Если у вас есть список текстур атомов, освободите их здесь
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
