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

public class MenuScreen2 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button_one;
    private ButtonView button_two;
    private ButtonView button_three;
    private ButtonView button_four;
    private ButtonView button_five;
    private ButtonView button_six;

    public MenuScreen2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_MENU_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        button_one = new ButtonView(25, 300, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "Механические явления");
        button_two = new ButtonView(303, 300, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "Тепловые явления");
        button_three = new ButtonView(25, 200, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "Электромагнитные явления");
        button_four = new ButtonView(303, 200, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "Квантовые явления");
        button_five = new ButtonView(25, 100, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "Тесты");
        button_six = new ButtonView(303, 100, 290, 80, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "Учёные");
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
        button_five.draw(myGdxGame.batch);
        button_six.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_one.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);

            }
//            if (exitButton.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
//                Gdx.app.exit();
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
        button_five.dispose();
        button_six.dispose();
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
