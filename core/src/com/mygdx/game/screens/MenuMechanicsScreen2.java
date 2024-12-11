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

public class MenuMechanicsScreen2 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button_ten;
    private ButtonView button_eleven;
    private ButtonView button_twelve;
    private ButtonView button_thirteen;
    private ButtonView button_fourteen;
    private ButtonView button_fifteen;
    private ButtonView button_sixteen;

    private ButtonView button_left;

    public MenuMechanicsScreen2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        button_ten = new ButtonView(25, 320, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_RED_IMG_PATH, "10. Виды энергии");
        button_eleven = new ButtonView(275, 320, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "11. Простые" + "\n" + "  механизмы");
        button_twelve = new ButtonView(515, 320, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_YELLO_IMG_PATH, "12. Давление");
        button_thirteen = new ButtonView(25, 180, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_BROWN_IMG_PATH, "13. Закон Паскаля");
        button_fourteen = new ButtonView(275, 180, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_PINK_IMG_PATH, "14. Закон Архимеда");
        button_fifteen = new ButtonView(515, 180, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH,"15. Звук");
        button_sixteen = new ButtonView(275, 40, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_RED_IMG_PATH,"16. Механические" + "\n" + "       колебания");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
    }

    @Override
    public void render(float delta) {

        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        button_ten.draw(myGdxGame.batch);
        button_eleven.draw(myGdxGame.batch);
        button_twelve.draw(myGdxGame.batch);
        button_thirteen.draw(myGdxGame.batch);
        button_fourteen.draw(myGdxGame.batch);
        button_fifteen.draw(myGdxGame.batch);
        button_sixteen.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuMechanicsScreen);

            }
            if (button_ten.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen28);

            }
            if (button_eleven.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen32);

            }
            if (button_twelve.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen34);

            }
            if (button_thirteen.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen36);

            }
            if (button_fourteen.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen37);

            }
            if (button_fifteen.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen39);

            }
            if (button_sixteen.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen41);

            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();

        button_ten.dispose();
        button_eleven.dispose();
        button_twelve.dispose();
        button_thirteen.dispose();
        button_fourteen.dispose();
        button_fifteen.dispose();
        button_sixteen.dispose();

        button_left.dispose();
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
