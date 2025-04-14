package com.mygdx.game.screens.tests.testThermal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;
import com.mygdx.game.components.TextView;
import com.mygdx.game.screens.tests.testMechanics.TestMechanics1;
import com.mygdx.game.screens.tests.testMechanics.TestMechanics2;

public class TestThermalFinish implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView btnResult;
    private ButtonView btnAgain;
    private ButtonView button_left;
    private ButtonView button_back;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView textResult;
    boolean isClickResult = false;

    public TestThermalFinish(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        background = new Texture("doska_background.png");

        btnResult = new ButtonView(120, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Показать результат");
        btnAgain = new ButtonView(400, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Пройти заново");

        text1 = new TextView(myGdxGame.commonRedFont, 30, 260, "Поздравляю! Ты отлично справился с тестом, а значит хорошо" + "\n" +
                "усвоил материал! Продолжай в том же духе!");

        text2 = new TextView(myGdxGame.commonRedFont, 30, 260, "Неплохо! Ты уже многое знаешь, но иногда ошибаешься." + "\n" +
                "Повтори материал и пройди тест заново. У тебя всё получится!");

        text3 = new TextView(myGdxGame.commonRedFont, 30, 260, "Ты можешь лучше! Я в тебя верю! Повтори теорию ещё раз и" + "\n" +
                "возвращайся к тесту с восполненными знаниями!");

        textResult = new TextView(myGdxGame.commonRedFont, 280, 390, "Твой результат: " + GameSettings.THERMAL_TEST_COUNTER + " из 4!");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
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

        if (isClickResult) textResult.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER > 3 && isClickResult) text1.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER > 1 && GameSettings.THERMAL_TEST_COUNTER <= 3 && isClickResult) text2.draw(myGdxGame.batch);

        if (GameSettings.THERMAL_TEST_COUNTER <= 1 && isClickResult) text3.draw(myGdxGame.batch);

        btnResult.draw(myGdxGame.batch);
        btnAgain.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btnResult.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                isClickResult = true;
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

        TestThermal1.isTrue = false;
        TestThermal1.isFilled1 = false;
        TestThermal1.isFilled2 = false;
        TestThermal1.isFilled3 = false;
        TestThermal1.isFilled4 = false;

        TestThermal2.isTrue = false;
        TestThermal2.isFilled1 = false;
        TestThermal2.isFilled2 = false;
        TestThermal2.isFilled3 = false;
        TestThermal2.isFilled4 = false;
    }

    @Override
    public void dispose() {
        background.dispose();

        btnResult.dispose();
        btnAgain.dispose();

        textResult.dispose();

        text1.dispose();
        text2.dispose();
        text3.dispose();

        button_left.dispose();
        button_back.dispose();
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
