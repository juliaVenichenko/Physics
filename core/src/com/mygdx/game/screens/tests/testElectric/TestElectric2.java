package com.mygdx.game.screens.tests.testElectric;

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

public class TestElectric2 extends MainTest implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    static boolean isTrueElectric2;
    static public boolean isFilledElectric1 = false;
    static public boolean isFilledElectric2 = false;
    static public boolean isFilledElectric3 = false;
    static public boolean isFilledElectric4 = false;
    ButtonView button_left;
    ButtonView button_right;

    public TestElectric2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTest(myGdxGame);

        text1 = new TextView(myGdxGame.commonRedFont, 40, 290, "Какое количество теплоты" + "\n" +
                "выделится в резисторе с" + "\n" +  "сопротивлением 5 Ом, через" + "\n" +  "который проходит ток  силой" + "\n" + "3 А в течение 10 секунд?");

        text2 = new TextView(myGdxGame.commonRedFont, 480, 370, "Что такое линза?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 420, 280, "Непрозрачное тело," + "\n" +  "отражающее световые лучи.");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 420, 210, "Прибор для измерения силы" + "\n" + "тока.");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 420, 130, "Прозрачное тело," + "\n" + "ограниченное двумя" + "\n" + "сферическими поверхностями");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 420, 60, "Вещество, не проводящее" + "\n" + "электрический ток.");

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
        if (isTrueElectric2) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50); // Установка позиции и размера galka
        }

        if (isFilledElectric1) btnFilled1.draw(myGdxGame.batch);
        else btnFilledNot1.draw(myGdxGame.batch);

        if (isFilledElectric2) btnFilled2.draw(myGdxGame.batch);
        else btnFilledNot2.draw(myGdxGame.batch);

        if (isFilledElectric3) btnFilled3.draw(myGdxGame.batch);
        else btnFilledNot3.draw(myGdxGame.batch);

        if (isFilledElectric4) btnFilled4.draw(myGdxGame.batch);
        else btnFilledNot4.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void checkAnswer() {
        if (textFieldInput.equals("450")) {
            isTrueElectric2 = true; // Устанавливаем флаг
            GameSettings.ELECTRIC_TEST_COUNTER += 1;
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
                isFilledElectric1 = true;
                isFilledElectric2 = false;
                isFilledElectric3 = false;
                isFilledElectric4 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 0;
            }
            if (btnFilledNot2.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledElectric2 = true;
                isFilledElectric1 = false;
                isFilledElectric3 = false;
                isFilledElectric4 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 0;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledElectric3 = true;
                isFilledElectric1 = false;
                isFilledElectric2 = false;
                isFilledElectric4 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 1;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledElectric4 = true;
                isFilledElectric1 = false;
                isFilledElectric2 = false;
                isFilledElectric3 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 0;
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testElectric1);
            }
            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testElectricFinish);
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

