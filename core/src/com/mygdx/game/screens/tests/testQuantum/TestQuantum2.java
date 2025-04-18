package com.mygdx.game.screens.tests.testQuantum;

import com.badlogic.gdx.Gdx;
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

public class TestQuantum2 implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    private Texture background;
    private Texture galka;
    private ButtonView btn;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    ImageView btnFilled1;
    ImageView btnFilled2;
    ImageView btnFilled3;
    ImageView btnFilled4;
    ImageView btnFilledNot1;
    ImageView btnFilledNot2;
    ImageView btnFilledNot3;
    ImageView btnFilledNot4;
    public static boolean isFilled1 = false;
    public static boolean isFilled2 = false;
    public static boolean isFilled3 = false;
    public static boolean isFilled4 = false;
    TextView textTask1;
    TextView textTask2;
    TextView textTask3;
    TextView textTask4;
    TextView text1;
    TextView text2;
    public static boolean isTrue = false;

    private String textFieldInput = "";

    public TestQuantum2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        background = new Texture("doska_background.png");
        galka = new Texture("galka.png");
        btn = new ButtonView(45, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Проверить");

        btnFilled1 = new ImageView(410, 280, 30, 30, "button_filled.png");
        btnFilled2 = new ImageView(410, 210, 30, 30, "button_filled.png");
        btnFilled3 = new ImageView(410, 140, 30, 30, "button_filled.png");
        btnFilled4 = new ImageView(410, 60, 30, 30, "button_filled.png");

        btnFilledNot1 = new ImageView(410, 280, 30, 30, "button_filledNot.png");
        btnFilledNot2 = new ImageView(410, 210, 30, 30, "button_filledNot.png");
        btnFilledNot3 = new ImageView(410, 140, 30, 30, "button_filledNot.png");
        btnFilledNot4 = new ImageView(410, 60, 30, 30, "button_filledNot.png");

        text1 = new TextView(myGdxGame.commonRedFont, 40, 330, "В ядре содержится 25 нейтронов" + "\n" + "и 29 протонов. Какого массовое" + "\n" + "число ядра?");

        text2 = new TextView(myGdxGame.commonRedFont, 480, 370, "Что такое изотопы?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 450, 280, "Атомы с разным числом" + "\n" + "протонов.");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 450, 210, "Атомы с разным числом" + "\n" + "электронов.");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 450, 130, "Атомы с разным числом" + "\n" + "нейтронов, но одинаковым" + "\n" + "числом протонов.");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 450, 60, "Атомы с одинаковым числом" + "\n" + "нейтронов и протонов.");

        Gdx.input.setInputProcessor(this); // Устанавливаем InputProcessor

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);
        button_back = new ButtonView(25, 390, 65, 65, GameResources.BUTTON_BACK_IMG_PATH);

    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background, 0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);

        // Рисуем текстовое поле
        drawTextField();

        textTask1.draw(myGdxGame.batch);
        textTask2.draw(myGdxGame.batch);
        textTask3.draw(myGdxGame.batch);
        textTask4.draw(myGdxGame.batch);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);

        btn.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);


        // Если isTrue равно true, отрисовываем galka
        if (isTrue) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50); // Установка позиции и размера galka
        }

        if (isFilled1) btnFilled1.draw(myGdxGame.batch);
        else btnFilledNot1.draw(myGdxGame.batch);

        if (isFilled2) btnFilled2.draw(myGdxGame.batch);
        else btnFilledNot2.draw(myGdxGame.batch);

        if (isFilled3) btnFilled3.draw(myGdxGame.batch);
        else btnFilledNot3.draw(myGdxGame.batch);

        if (isFilled4) btnFilled4.draw(myGdxGame.batch);
        else btnFilledNot4.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void checkAnswer() {
        if (textFieldInput.equals("54")) {
            isTrue = true; // Устанавливаем флаг
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

            if (btnFilledNot1.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilled1 = true;
                isFilled2 = false;
                isFilled3 = false;
                isFilled4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
            }
            if (btnFilledNot2.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilled2 = true;
                isFilled1 = false;
                isFilled3 = false;
                isFilled4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
//                if (GameSettings.MECHANICS_TEST_COUNTER == 0) GameSettings.MECHANICS_TEST_COUNTER = 0;
//                else GameSettings.MECHANICS_TEST_COUNTER -= 1;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilled3 = true;
                isFilled1 = false;
                isFilled2 = false;
                isFilled4 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 1;
//                GameSettings.THERMAL_TEST_COUNTER += 0;
//                if (GameSettings.MECHANICS_TEST_COUNTER == 0) GameSettings.MECHANICS_TEST_COUNTER = 0;
//                else GameSettings.MECHANICS_TEST_COUNTER -= 1;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilled4 = true;
                isFilled1 = false;
                isFilled2 = false;
                isFilled3 = false;

                GameSettings.QUANTUM_TEST_COUNTER += 0;
                //if (GameSettings.MECHANICS_TEST_COUNTER == 0) GameSettings.MECHANICS_TEST_COUNTER = 0;
                //else GameSettings.MECHANICS_TEST_COUNTER -= 1;
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testQuantum1);
            }
            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testQuantumFinish);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
        }
    }

    private void drawTextField() {
        // Рисуем фон текстового поля
        myGdxGame.batch.setColor(Color.LIGHT_GRAY);
        myGdxGame.batch.draw(new Texture("InputField.png"), 40, 170, 300, 80);
        myGdxGame.batch.setColor(Color.WHITE);

        // Рисуем текст
        myGdxGame.commonWhiteFont.draw(myGdxGame.batch, textFieldInput, 50, 210);
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
        background.dispose();
        galka.dispose();
        btn.dispose();

        btnFilled1.dispose();
        btnFilled2.dispose();
        btnFilled3.dispose();
        btnFilled4.dispose();

        btnFilledNot1.dispose();
        btnFilledNot2.dispose();
        btnFilledNot3.dispose();
        btnFilledNot4.dispose();

        textTask1.dispose();
        textTask2.dispose();
        textTask3.dispose();
        textTask4.dispose();
        text1.dispose();
        text2.dispose();

        button_left.dispose();
        button_right.dispose();
        button_back.dispose();
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
