package com.juliaVenichenko.physics.screens.tests.testElectric;

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

public class TestElectric1 extends MainTest implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    ButtonView button_right;
    static boolean isTrueElectric1 = false;

    static public boolean isFilledElectric1 = false;
    static public boolean isFilledElectric2 = false;
    static public boolean isFilledElectric3 = false;
    static public boolean isFilledElectric4 = false;

    public TestElectric1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTest(myGdxGame);

        text1 = new TextView(myGdxGame.commonRedFont, 40, 320, "Какую силу тока создаёт резистор" + "\n" +
                "с сопротивлением 10 Ом, если на" + "\n" + "него подаётся напряжение 20 В?");

        text2 = new TextView(myGdxGame.commonRedFont, 460, 360, "Что такое диэлектрик?");

        textTask1 = new TextView(myGdxGame.commonWhiteFont, 420, 290, "Вещество, хорошо проводящее" + "\n" + "электрический ток.");
        textTask2 = new TextView(myGdxGame.commonWhiteFont, 420, 210, "Вещество, не проводящее" + "\n" + "электрический ток.");
        textTask3 = new TextView(myGdxGame.commonWhiteFont, 420, 130, "Вещество, способное излучать" + "\n" + "свет.");
        textTask4 = new TextView(myGdxGame.commonWhiteFont, 420, 50, "Вещество, обладающее" + "\n" + "магнитными свойствами.");

        Gdx.input.setInputProcessor(this);

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

        if (isTrue(isTrueElectric1)) {
            myGdxGame.batch.draw(galka, 280, 180, 50, 50);
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
        if (textFieldInput.equals("2")) {
            isTrueElectric1 = true;
            GameSettings.ELECTRIC_TEST_COUNTER += 1;
        }
        textFieldInput = "";
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btn.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                checkAnswer();
            }

            if (inputField.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                showTextInputDialog();
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

                GameSettings.ELECTRIC_TEST_COUNTER += 1;
            }
            if (btnFilledNot3.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledElectric3 = true;
                isFilledElectric1 = false;
                isFilledElectric2 = false;
                isFilledElectric4 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 0;
            }
            if (btnFilledNot4.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isFilledElectric4 = true;
                isFilledElectric1 = false;
                isFilledElectric2 = false;
                isFilledElectric3 = false;

                GameSettings.ELECTRIC_TEST_COUNTER += 0;
            }

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testElectric2);
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
        if (character == '\n') {
            checkAnswer();
        } else if (character == '\b') {
            if (textFieldInput.length() > 0) {
                textFieldInput = textFieldInput.substring(0, textFieldInput.length() - 1);
            }
        } else {
            textFieldInput += character;
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
