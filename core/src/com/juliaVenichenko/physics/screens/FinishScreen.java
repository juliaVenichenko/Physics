package com.juliaVenichenko.physics.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.TextView;

public class FinishScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private ButtonView button_left;
    private ButtonView button_back;
    private ButtonView button_tests;
    public FinishScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text1 = new TextView(myGdxGame.commonRedFont, 310, 400, "НА ЭТОМ ПОКА ВСЁ!");
        text2 = new TextView(myGdxGame.commonWhiteFont, 50, 260, "              Ты прошёл весь теоретический материал." + "\n" + "\n" +
                "            Самое время для решения тестовых заданий!");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_tests = new ButtonView(280, 50, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Тесты");

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_tests.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen11);
            }
            if (button_tests.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuTestScreen);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen2);
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();

        button_left.dispose();
        button_tests.dispose();
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