package com.mygdx.game.screens.tests.testThermal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;
import com.mygdx.game.components.ImageView;
import com.mygdx.game.components.TextView;
import com.mygdx.game.screens.tests.MainTest;

public class TestThermal2 extends MainTest implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    static boolean isTrueThermal2;
    static public boolean isFilledThermal1 = false;
    static public boolean isFilledThermal2 = false;
    static public boolean isFilledThermal3 = false;
    static public boolean isFilledThermal4 = false;
    ButtonView button_left;
    ButtonView button_right;


    public TestThermal2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTest(myGdxGame);

        text1 = new TextView(myGdxGame.commonRedFont, 40, 290, "Какое количество теплоты" + "\n" +
                "необходимо для нагрева 150 г" + "\n" + "железа от 25 C до 75 C?" + "\n" + "(Удельная теплоёмкость" + "\n" + "железа = 0,45 Дж/(г*C))");

        text2 = new TextView(myGdxGame.commonRedFont, 400, 330, "Как рассчитывается количество" + "\n" + "теплоты, необходимое для" + "\n" + "нагревания вещества?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 410, 300, "Q = m * g * t(дельта)");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 410, 220, "Q = m * L");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 410, 140, "Q = m * g * h");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 410, 60, "Q = r * m");

        Gdx.input.setInputProcessor(this); // Устанавливаем InputProcessor

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        drawTest(myGdxGame);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        // Если isTrue равно true, отрисовываем galka
        if (isTrue(isTrueThermal2)) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50); // Установка позиции и размера galka
        }

        if (isFilledThermal1) btnFilled1.draw(myGdxGame.batch);
        else btnFilledNot1.draw(myGdxGame.batch);

        if (isFilledThermal2) btnFilled2.draw(myGdxGame.batch);
        else btnFilledNot2.draw(myGdxGame.batch);

        if (isFilledThermal3) btnFilled3.draw(myGdxGame.batch);
        else btnFilledNot3.draw(myGdxGame.batch);

        if (isFilledThermal4) btnFilled4.draw(myGdxGame.batch);
        else btnFilledNot4.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void checkAnswer() {
        if (textFieldInput.equals("3 375") || textFieldInput.equals("3375")) {
            isTrueThermal2 = true; // Устанавливаем флаг
            GameSettings.THERMAL_TEST_COUNTER += 1;
        }
        textFieldInput = ""; // Очищаем текстовое поле после проверки
    }
    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btn.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                checkAnswer();
            }

            // Проверяем, попал ли пользователь в поле ввода
            if (inputField.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                showTextInputDialog(); // Показать диалог ввода текста
            }

            if (btnFilledNot1.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledThermal1 = true;
                isFilledThermal2 = false;
                isFilledThermal3 = false;
                isFilledThermal4 = false;

                GameSettings.THERMAL_TEST_COUNTER += 1;
            }
            if (btnFilledNot2.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledThermal2 = true;
                isFilledThermal1 = false;
                isFilledThermal3 = false;
                isFilledThermal4 = false;

                GameSettings.THERMAL_TEST_COUNTER += 0;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledThermal3 = true;
                isFilledThermal1 = false;
                isFilledThermal2 = false;
                isFilledThermal4 = false;

                GameSettings.THERMAL_TEST_COUNTER += 0;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledThermal4 = true;
                isFilledThermal1 = false;
                isFilledThermal2 = false;
                isFilledThermal3 = false;

                GameSettings.THERMAL_TEST_COUNTER += 0;
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testThermal1);
            }
            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testThermalFinish);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        // Обработка ввода текста
        if (character == '\n') {
            checkAnswer();// Проверка ответа при нажатии Enter
        } else if (character == '\b') { // Обработка Backspace
            if (textFieldInput.length() > 0) {
                textFieldInput = textFieldInput.substring(0, textFieldInput.length() - 1);
            }
        } else {
            textFieldInput += character; // Добавление символа к тексту
        }
        return true;
    }

    @Override
    public void dispose() {
        disposeTest();

        button_left.dispose();
        button_right.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
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
