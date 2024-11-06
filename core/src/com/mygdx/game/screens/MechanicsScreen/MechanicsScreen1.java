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

public class MechanicsScreen1 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private TextView text7;
    private TextView text8;
    private ButtonView button_left;
    private ButtonView button_right;
    public MechanicsScreen1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text1 = new TextView(myGdxGame.commonWhiteFont, 30, 420, "  Механическим движением тела называют его положения в пространстве" + "\n" +
                "относительно других тел с течением времени.");
        text2 = new TextView(myGdxGame.commonWhiteFont, 330, 380, "ВИДЫ ДВИЖЕНИЯ");
        text3 = new TextView(myGdxGame.commonWhiteFont, 280, 330, "ПРЯМОЛИНЕЙНОЕ ДВИЖЕНИЕ");
        text4 = new TextView(myGdxGame.commonWhiteFont, 30, 230, "  Равномерное - движение, при котором тело за равные промежутки времени" + "\n" +
                "проходит одинаковое расстояние относительно других тел с течением времени." + "\n" +
                "   Неравномерное - движение, при котором тело за равные промежутки времени" + "\n" + "проходит неодинаковое расстояние.");
        text5 = new TextView(myGdxGame.commonWhiteFont, 280, 180, "КРИВОЛИНЕЙНОЕ ДВИЖЕНИЕ");
        text6 = new TextView(myGdxGame.commonWhiteFont, 30, 80, "  Вращательное - движение в одном направлении по плоской (или пространственной)" + "\n" +
                "замкнутой траектории." + "\n" + "  Колебательное - движение, которое полностью или практически полностью" + "\n" + "повторяется с течением времени.");
//        text7 = new TextView(myGdxGame.commonWhiteFont, 330, 120, "СИСТЕМА ОТСЧЁТА");
//        text8 = new TextView(myGdxGame.commonWhiteFont, 30, 70, "   Тело отсчёта - произвольно выбранное тело, относительно которого определяется" + "\n" +
//                "положение движущейся материальной точки (или тела).");

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
        text5.draw(myGdxGame.batch);
        text6.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);
//        text7.draw(myGdxGame.batch);
//        text8.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen2);

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
        text5.dispose();
        text6.dispose();

        button_left.dispose();
        button_right.dispose();
//        text7.dispose();
//        text8.dispose();
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
