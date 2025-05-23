package com.juliaVenichenko.physics.screens.tests.testMechanics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.TextView;
import com.juliaVenichenko.physics.screens.tests.MainTest;

public class TestMechanics1 extends MainTest implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    ButtonView button_right;
    static boolean isTrueMechanics1 = false;
    static public boolean isFilledMechanics1 = false;
    static public boolean isFilledMechanics2 = false;
    static public boolean isFilledMechanics3 = false;
    static public boolean isFilledMechanics4 = false;
    public TestMechanics1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTest(myGdxGame);

        text1 = new TextView(myGdxGame.commonRedFont, 40, 290, "Какова потенциальная" + "\n" + "энергия тела массой 5 кг," + "\n" +
                "находящегося на высоте" + "\n" + "10 метров?" + "\n" + "(Используйте g = 9.8 м/с²)");

        text2 = new TextView(myGdxGame.commonRedFont, 420, 370, "Что такое сила трения?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 400, 290, "Сила, вызывающая ускорение" + "\n" + "тела.");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 400, 210, "Сила, препятствующая движению" + "\n" + "тел относительно друг друга.");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 400, 130, "Сила, действующая на тело в" + "\n" + "свободном падении.");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 400, 50, "Сила, равная массе тела," + "\n" + "умноженной на ускорение");

        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        Gdx.input.setInputProcessor(this); // Устанавливаем InputProcessor

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
        if (isTrue(isTrueMechanics1)) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50); // Установка позиции и размера galka
        }

        if (isFilledMechanics1) btnFilled1.draw(myGdxGame.batch);
        else btnFilledNot1.draw(myGdxGame.batch);

        if (isFilledMechanics2) btnFilled2.draw(myGdxGame.batch);
        else btnFilledNot2.draw(myGdxGame.batch);

        if (isFilledMechanics3) btnFilled3.draw(myGdxGame.batch);
        else btnFilledNot3.draw(myGdxGame.batch);

        if (isFilledMechanics4) btnFilled4.draw(myGdxGame.batch);
        else btnFilledNot4.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void checkAnswer() {
        if (textFieldInput.equals("490")) {
            isTrueMechanics1 = true; // Устанавливаем флаг
            GameSettings.MECHANICS_TEST_COUNTER += 1;
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
                isFilledMechanics1 = true;
                isFilledMechanics2 = false;
                isFilledMechanics3 = false;
                isFilledMechanics4 = false;

                GameSettings.MECHANICS_TEST_COUNTER += 0;
            }
            if (btnFilledNot2.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledMechanics2 = true;
                isFilledMechanics1 = false;
                isFilledMechanics3 = false;
                isFilledMechanics4 = false;

                GameSettings.MECHANICS_TEST_COUNTER += 1;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledMechanics3 = true;
                isFilledMechanics1 = false;
                isFilledMechanics2 = false;
                isFilledMechanics4 = false;

                GameSettings.MECHANICS_TEST_COUNTER += 0;;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledMechanics4 = true;
                isFilledMechanics1 = false;
                isFilledMechanics2 = false;
                isFilledMechanics3 = false;

                GameSettings.MECHANICS_TEST_COUNTER += 0;
            }

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testMechanics2);
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
        if (character == '\b') { // Обработка Backspace
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
