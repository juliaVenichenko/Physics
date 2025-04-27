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

public class MenuElectricScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button_one;
    private ButtonView button_two;
    private ButtonView button_three;
    private ButtonView button_four;
    private ButtonView button_five;
    private ButtonView button_six;
    private ButtonView button_seven;
    private ButtonView button_eight;
    private ButtonView button_nine;

    private ButtonView button_right;
    private ButtonView button_back;

    public MenuElectricScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        button_one = new ButtonView(25, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "1. Электризация" + "\n" + "        тел");
        button_two = new ButtonView(275, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "2. Электрический" + "\n" + "         заряд");
        button_three = new ButtonView(515, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "3. Закон Кулона");
        button_four = new ButtonView(25, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "4. Электрическое" + "\n" + "         поле");
        button_five = new ButtonView(275, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "5. Постоянный" + "\n" + "электрический" + "\n" + "        ток");
        button_six = new ButtonView(515, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "6. Напряжение");
        button_seven = new ButtonView(25, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "7. Электрическое" + "\n" + "  сопротивление");
        button_eight = new ButtonView(275, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "8. Закон Ома");
        button_nine = new ButtonView(515, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "   9. Мощность" + "\n" + "электрического" + "\n" + "        тока");

        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);
        button_back = new ButtonView(25, 20, 60, 60, GameResources.BUTTON_BACK_IMG_PATH);
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
        button_seven.draw(myGdxGame.batch);
        button_eight.draw(myGdxGame.batch);
        button_nine.draw(myGdxGame.batch);

        button_right.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuElectricScreen2);

            }
            if (button_one.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen1);

            }
            if (button_two.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen2);

            }
            if (button_three.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen3);

            }
            if (button_four.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen4);

            }
            if (button_five.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen6);

            }
            if (button_six.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen7);

            }
            if (button_seven.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen8);

            }
            if (button_eight.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen10);

            }
            if (button_nine.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.electricScreen11);

            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen2);

            }
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
        button_seven.dispose();
        button_eight.dispose();
        button_nine.dispose();

        button_right.dispose();
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
