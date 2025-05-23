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

public class MenuMechanicsScreen implements Screen {
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

    public MenuMechanicsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        button_one = new ButtonView(25, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "1. Виды движения");
        button_two = new ButtonView(275, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "2. Масса тела");
        button_three = new ButtonView(515, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "3. Сила");
        button_four = new ButtonView(25, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "4. Инерция");
        button_five = new ButtonView(275, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "5. Сила трения");
        button_six = new ButtonView(515, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "6. Деформация");
        button_seven = new ButtonView(25, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "7. Сила притяжения");
        button_eight = new ButtonView(275, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "  8. Закон" + "\n" + "сохранения" + "\n" + " импульса");
        button_nine = new ButtonView(515, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "9. Механическая" + "\n" + "       работа");

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

            if (button_one.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen1);

            }
            if (button_two.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen11);

            }
            if (button_three.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen13);

            }
            if (button_four.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen14);

            }
            if (button_five.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen18);

            }
            if (button_six.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen20);

            }
            if (button_seven.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen23);

            }
            if (button_eight.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen25);

            }
            if (button_nine.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen27);

            }
            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuMechanicsScreen2);

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
