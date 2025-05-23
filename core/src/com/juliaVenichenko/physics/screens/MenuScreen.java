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

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView startButton;
    private ButtonView faqButton;
    private ButtonView exitButton;
    private ButtonView physiconButton;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_MENU_IMG_PATH);

    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        startButton = new ButtonView(10, 220, 290, 100, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Читать");
        faqButton = new ButtonView(10, 380, 60, 100, GameResources.BUTTON_QUESTION_IMG_PATH);
        exitButton = new ButtonView(10, 110, 290, 100, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Выход");
        physiconButton = new ButtonView(650, 10, 140, 150, GameResources.BUTTON_PHUSICON_IMG_PATH);
    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);

        startButton.draw(myGdxGame.batch);
        faqButton.draw(myGdxGame.batch);
        exitButton.draw(myGdxGame.batch);
        physiconButton.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (startButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen2);
            }
            if (faqButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.questionScreen);
            }
            if (physiconButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.chatGPT);
            }
            if (exitButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        startButton.dispose();
        faqButton.dispose();
        exitButton.dispose();
        physiconButton.dispose();
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
