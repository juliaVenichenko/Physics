package com.juliaVenichenko.physics.screens.tests.testMechanics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.screens.tests.MainTestFinish;

public class TestMechanicsFinish extends MainTestFinish implements Screen {
    MyGdxGame myGdxGame;
    boolean isClickResult = false;

    public TestMechanicsFinish(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTestFinish(myGdxGame, GameSettings.MECHANICS_TEST_COUNTER);

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

        if (GameSettings.MECHANICS_TEST_COUNTER > 3 && isClickResult) text1.draw(myGdxGame.batch);

        if (GameSettings.MECHANICS_TEST_COUNTER > 1 && GameSettings.MECHANICS_TEST_COUNTER <= 3 && isClickResult) text2.draw(myGdxGame.batch);

        if (GameSettings.MECHANICS_TEST_COUNTER <= 1 && isClickResult) text3.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btnResult.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isClickResult = true;
                if (GameSettings.MECHANICS_TEST_COUNTER > 3 && isClickResult) myGdxGame.audioManager.victory.play();
                if (GameSettings.MECHANICS_TEST_COUNTER <= 1 && isClickResult) myGdxGame.audioManager.gameOver.play();
                if (GameSettings.MECHANICS_TEST_COUNTER > 1 && GameSettings.MECHANICS_TEST_COUNTER <= 3 && isClickResult) myGdxGame.audioManager.almostGameOver.play();
            }

            if (btnAgain.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                resetGame();
                myGdxGame.setScreen(myGdxGame.testMechanics1);
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testMechanics2);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
        }
    }

    private void resetGame() {
        GameSettings.MECHANICS_TEST_COUNTER = 0;
        isClickResult = false;

        TestMechanics1.isTrueMechanics1 = false;
        TestMechanics1.isFilledMechanics1 = false;
        TestMechanics1.isFilledMechanics2 = false;
        TestMechanics1.isFilledMechanics3 = false;
        TestMechanics1.isFilledMechanics4 = false;

        TestMechanics2.isTrueMechanics2 = false;
        TestMechanics2.isFilledMechanics1 = false;
        TestMechanics2.isFilledMechanics2 = false;
        TestMechanics2.isFilledMechanics3 = false;
        TestMechanics2.isFilledMechanics4 = false;
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
