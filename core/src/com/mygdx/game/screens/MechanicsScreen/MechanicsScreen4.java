package com.mygdx.game.screens.MechanicsScreen;

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
import com.mygdx.game.components.ImageView;
import com.mygdx.game.components.TextView;

public class MechanicsScreen4 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private ButtonView button_left;
    private ButtonView button_right;
    private ImageView formula_1;
    public MechanicsScreen4(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text1 = new TextView(myGdxGame.commonWhiteFont, 220, 420, "РАВНОМЕРНОЕ ПРЯМОЛИНЕЙНОЕ ДВИЖЕНИЕ");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 360, "  Равномерное прямолинейное движение - движение, при котором тело за любые" + "\n" +
                "равные промежутки времени проходит равные расстояния.");
        text3 = new TextView(myGdxGame.commonWhiteFont, 245, 310, "Зависимость координаты от времени");
        formula_1 = new ImageView(315, 220, 180, 50, GameResources.FORMULA_1_IMG);
        text4 = new TextView(myGdxGame.commonWhiteFont, 200, 165, "РАВНОУСКОРЕННОЕ ПРЯМОЛИНЕЙНОЕ ДВИЖЕНИЕ");
        text5 = new TextView(myGdxGame.commonWhiteFont, 30, 100, "  Равноускоренное движение - движение, при котором за любые равные промежутки" + "\n" +
                "времени материальная точка изменяет свою скорость на одну и ту же велечину.");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

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
        text3.draw(myGdxGame.batch);
        text4.draw(myGdxGame.batch);
        formula_1.draw(myGdxGame.batch);
        text5.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen5);
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen3);

            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();
        text3.dispose();
        text4.dispose();
        formula_1.dispose();
        text5.dispose();

        button_left.dispose();
        button_right.dispose();
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