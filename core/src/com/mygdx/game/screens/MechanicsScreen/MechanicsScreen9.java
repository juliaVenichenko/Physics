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
import com.mygdx.game.components.TextView;

public class MechanicsScreen9 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView formula_4;
    private ButtonView formula_5;
    private ButtonView button_left;
    private ButtonView button_right;
    public MechanicsScreen9(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        formula_4 = new ButtonView(50, 140, 330, 290, GameResources.FORMULA_4_IMG);
        formula_5 = new ButtonView(420, 140, 330, 290, GameResources.FORMULA_5_IMG);

//        text1 = new TextView(myGdxGame.commonWhiteFont, 320, 410, "ЯВЛЕНИЕ ИНЕРЦИИ");
//        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 360, "  Инерция - свойство тел сохранять своё состояние неизменным.");
//        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 300, " Движение по инерции - движение тела, происходящее без внешних воздействий.");
//        text4 = new TextView(myGdxGame.commonWhiteFont, 30, 200, " Инерциальная система отсчёта (ИСО) - система отсчёта, где тело, на которое" + "\n" +
//                "не действуют внешние силы (или действие сил  скомпенсиравано)," + "\n" + "движется бесконечно долго, прямолинейно и равномерно или покоится.");

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

       formula_4.draw(myGdxGame.batch);
       formula_5.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen10);
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen8);

            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        formula_4.dispose();
        formula_5.dispose();

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
