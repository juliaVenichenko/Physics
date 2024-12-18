package com.mygdx.game.screens;

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

public class MenuScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView startButton;
    private ButtonView faqButton;
    private ButtonView exitButton;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_MENU_IMG_PATH);

    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        startButton = new ButtonView(10, 220, 290, 100, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "Читать");
        faqButton = new ButtonView(10                                                                                                                                                                                        , 410, 50, 70, GameResources.BUTTON_QUESTION_IMG_PATH);
        exitButton = new ButtonView(10, 110, 290, 100, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "Выход");
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

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (startButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen2);
//                myGdxGame.audioManager.clickSound.play(0.2f);
            }
//            if (faqButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
//                myGdxGame.setScreen(myGdxGame.);
//            }
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
