package com.mygdx.game.screens.tests.testQuantum;

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

public class TestQuantum1 extends MainTest implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    ButtonView button_right;
    static boolean isTrueQuantum1 = false;

    static public boolean isFilledQuantum1 = false;
    static public boolean isFilledQuantum2 = false;
    static public boolean isFilledQuantum3 = false;
    static public boolean isFilledQuantum4 = false;

    public TestQuantum1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTest(myGdxGame);

        text1 = new TextView(myGdxGame.commonRedFont, 40, 320, "Ядро имеет массовое число 56." + "\n" +
                "В ядре содержится 26 протонов." + "\n" + "Сколько нейтронов в ядре?");

        text2 = new TextView(myGdxGame.commonRedFont, 440, 340, "Из каких частиц состоит" + "\n" + "        ядро атома?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 420, 300, "Из протонов и электронов.");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 420, 210, "Из протонов, нейтронов и" + "\n" + "электронов");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 420, 140, "Из нейтронов и электронов.");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 420, 60, "Из протонов и нейтронов.");

        Gdx.input.setInputProcessor(this); // Устанавливаем InputProcessor

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

        button_right.draw(myGdxGame.batch);


        // Если isTrue равно true, отрисовываем galka
        if (isTrue(isTrueQuantum1)) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50); // Установка позиции и размера galka
        }

        if (isFilledQuantum1) btnFilled1.draw(myGdxGame.batch);
        else btnFilledNot1.draw(myGdxGame.batch);

        if (isFilledQuantum2) btnFilled2.draw(myGdxGame.batch);
        else btnFilledNot2.draw(myGdxGame.batch);

        if (isFilledQuantum3) btnFilled3.draw(myGdxGame.batch);
        else btnFilledNot3.draw(myGdxGame.batch);

        if (isFilledQuantum4) btnFilled4.draw(myGdxGame.batch);
        else btnFilledNot4.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void checkAnswer() {
        if (textFieldInput.equals("30")) {
            isTrueQuantum1 = true; // Устанавливаем флаг
            GameSettings.QUANTUM_TEST_COUNTER += 1;
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
                isFilledQuantum1 = true;
                isFilledQuantum2 = false;
                isFilledQuantum3 = false;
                isFilledQuantum4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
            }
            if (btnFilledNot2.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledQuantum2 = true;
                isFilledQuantum1 = false;
                isFilledQuantum3 = false;
                isFilledQuantum4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledQuantum3 = true;
                isFilledQuantum1 = false;
                isFilledQuantum2 = false;
                isFilledQuantum4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledQuantum4 = true;
                isFilledQuantum1 = false;
                isFilledQuantum2 = false;
                isFilledQuantum3 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 1;
            }

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testQuantum2);
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
