package com.juliaVenichenko.physics.screens.tests.testQuantum;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.screens.tests.MainTestFinish;

public class TestQuantumFinish extends MainTestFinish implements Screen {
    MyGdxGame myGdxGame;
    boolean isClickResult = false;

    public TestQuantumFinish(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        initializeTestFinish(myGdxGame, GameSettings.QUANTUM_TEST_COUNTER);

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

        if (GameSettings.QUANTUM_TEST_COUNTER > 3 && isClickResult) text1.draw(myGdxGame.batch);

        if (GameSettings.QUANTUM_TEST_COUNTER > 1 && GameSettings.QUANTUM_TEST_COUNTER <= 3 && isClickResult) text2.draw(myGdxGame.batch);

        if (GameSettings.QUANTUM_TEST_COUNTER <= 1 && isClickResult) text3.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btnResult.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isClickResult = true;
                if (GameSettings.QUANTUM_TEST_COUNTER > 3 && isClickResult) myGdxGame.audioManager.victory.play();
                if (GameSettings.QUANTUM_TEST_COUNTER <= 1 && isClickResult) myGdxGame.audioManager.gameOver.play();
                if (GameSettings.QUANTUM_TEST_COUNTER > 1 && GameSettings.QUANTUM_TEST_COUNTER <= 3 && isClickResult) myGdxGame.audioManager.almostGameOver.play();
            }

            if (btnAgain.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                resetGame();
                myGdxGame.setScreen(myGdxGame.testQuantum1);
            }

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testQuantum2);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
        }
    }

    private void resetGame() {
        GameSettings.QUANTUM_TEST_COUNTER = 0; // Сброс очков
        isClickResult = false;

        TestQuantum1.isTrueQuantum1 = false;
        TestQuantum1.isFilledQuantum1 = false;
        TestQuantum1.isFilledQuantum2 = false;
        TestQuantum1.isFilledQuantum3 = false;
        TestQuantum1.isFilledQuantum4 = false;

        TestQuantum2.isTrueQuantum2 = false;
        TestQuantum2.isFilledQuantum1 = false;
        TestQuantum2.isFilledQuantum2 = false;
        TestQuantum2.isFilledQuantum3 = false;
        TestQuantum2.isFilledQuantum4 = false;
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