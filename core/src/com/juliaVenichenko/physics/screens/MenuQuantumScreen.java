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

public class MenuQuantumScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button_one;
    private ButtonView button_two;
    private ButtonView button_three;
    private ButtonView button_four;
    private ButtonView button_five;
    private ButtonView button_six;
    private ButtonView button_seven;
    private ButtonView button_back;

    public MenuQuantumScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        button_one = new ButtonView(25, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "1. Радиоактивность");
        button_two = new ButtonView(275, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "2. Гипотеза Планка");
        button_three = new ButtonView(515, 340, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "3. Фотоны");
        button_four = new ButtonView(25, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "4. Импульс фотона");
        button_five = new ButtonView(275, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "5. Модель атома");
        button_six = new ButtonView(515, 210, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "   6. Состав" + "\n" + "атомного ядра");
        button_seven = new ButtonView(275, 80, 235, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "7. Ядерные реакции");

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

        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_one.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen1);

            }
            if (button_two.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen4);

            }
            if (button_three.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen5);

            }
            if (button_four.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen6);

            }
            if (button_five.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen7);

            }
            if (button_six.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen8);

            }
            if (button_seven.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.quantumScreen11);

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
