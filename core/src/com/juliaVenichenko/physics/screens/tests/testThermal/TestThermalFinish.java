package com.juliaVenichenko.physics.screens.tests.testThermal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.screens.tests.MainTestFinish;

public class TestThermalFinish extends MainTestFinish implements Screen {
    MyGdxGame myGdxGame;
    boolean isClickResult = false;

    public TestThermalFinish(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTestFinish(myGdxGame, GameSettings.THERMAL_TEST_COUNTER);

    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        drawTestFinish(myGdxGame);

        if (isClickResult) textResult.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER > 3 && isClickResult) text1.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER > 1 && GameSettings.THERMAL_TEST_COUNTER <= 3 && isClickResult) text2.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER <= 1 && isClickResult) text3.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btnResult.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isClickResult = true;
                if (GameSettings.THERMAL_TEST_COUNTER > 3 && isClickResult) myGdxGame.audioManager.victory.play();
                if (GameSettings.THERMAL_TEST_COUNTER <= 1 && isClickResult) myGdxGame.audioManager.gameOver.play();
                if (GameSettings.THERMAL_TEST_COUNTER > 1 && GameSettings.THERMAL_TEST_COUNTER <= 3 && isClickResult) myGdxGame.audioManager.almostGameOver.play();
            }

            if (btnAgain.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                resetGame();
                myGdxGame.setScreen(myGdxGame.testThermal1);
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testThermal2);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
        }
    }

    private void resetGame() {
        GameSettings.THERMAL_TEST_COUNTER = 0; // Сброс очков
        isClickResult = false;

        TestThermal1.isTrueThermal1 = false;
        TestThermal1.isFilledThermal1 = false;
        TestThermal1.isFilledThermal2 = false;
        TestThermal1.isFilledThermal3 = false;
        TestThermal1.isFilledThermal4 = false;

        TestThermal2.isTrueThermal2 = false;
        TestThermal2.isFilledThermal1 = false;
        TestThermal2.isFilledThermal2 = false;
        TestThermal2.isFilledThermal3 = false;
        TestThermal2.isFilledThermal4 = false;
    }

    @Override
    public void dispose() {
        disposeTestFinish();
        myGdxGame.audioManager.victory.dispose();
        myGdxGame.audioManager.gameOver.dispose();
        myGdxGame.audioManager.almostGameOver.dispose();
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
