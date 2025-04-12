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
import com.mygdx.game.components.TextView;

public class MenuTestScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button_one;
    private ButtonView button_two;
    private ButtonView button_three;
    private ButtonView button_four;
    private TextView text;
    private ButtonView button_back;

    public MenuTestScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text = new TextView(myGdxGame.commonRedFont, 368, 410, "ТЕСТЫ");

        button_one = new ButtonView(85, 250, 290, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Механические явления");
        button_two = new ButtonView(410, 250, 290, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Тепловые явления");
        button_three = new ButtonView(85, 90, 290, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Электромагнитные" + "\n" + "       явления");
        button_four = new ButtonView(410, 90, 290, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Квантовые явления");

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

        button_one.draw(myGdxGame.batch);
        button_two.draw(myGdxGame.batch);
        button_three.draw(myGdxGame.batch);
        button_four.draw(myGdxGame.batch);

        text.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen2);
            }
            if (button_one.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.testMechanics1);

            }
//            if (button_two.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
//                myGdxGame.setScreen(myGdxGame.quantumScreen4);
//
//            }
//            if (button_three.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
//                myGdxGame.setScreen(myGdxGame.quantumScreen5);
//
//            }
//            if (button_four.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
//                myGdxGame.setScreen(myGdxGame.quantumScreen6);
//
//            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        button_one.dispose();
        button_two.dispose();
        button_three.dispose();
        button_four.dispose();

        text.dispose();

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
