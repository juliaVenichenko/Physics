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

public class MechanicsScreen2 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private ButtonView button_left;
    private ButtonView button_right;
    public MechanicsScreen2(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text1 = new TextView(myGdxGame.commonWhiteFont, 330, 420, "СИСТЕМА ОТСЧЁТА");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 360, "   Тело отсчёта - произвольно выбранное тело, относительно которого определяется" + "\n" +
                "положение движущейся материальной точки (или тела).");
        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 150, "  Система отсчёта - совокупность системы координат и часов, связанных с телом" + "\n" + "отсчёта." + "\n" + "\n" +
                "Материальная точка - тело, размерами которого в данных условиях можно принебречь." + "\n" + "\n" +
                "  Радиус-вектор - вектор, соединяющий начало отсчёта с положением материальной" + "\n" + "точки в произвольный момент времени." + "\n" + "\n" +
                "   Относительность механического движения - зависимость траектории движения" + "\n" + "тела, пройденного пути, перемещения и скорости от выбора системы отсчёта.");
        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

//
//        text2 = new TextView(myGdxGame.commonWhiteFont, 260, 240, "ТРАЕКТОРИЯ. ПУТЬ. ПЕРЕМЕЩЕНИЕ");
//        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 140, "  Траектория - воображаемая линия, вдоль которой движется тело." + "\n" +
//                "   Перемещение - вектор, проведённый из начального положения материальной" + "\n" + "точки в конечное." + "\n" +
//                "   Пройденный путь s - длина участка траектории, пройденного материальной точкой" + "\n" + "за данный промежуток времени.");
//
//
//
//
//        text4 = new TextView(myGdxGame.commonWhiteFont, 30, 270, "  Равномерное - движение, при котором тело за равные промежутки времени" + "\n" +
//                "проходит одинаковое расстояние относительно других тел с течением времени." + "\n" +
//                "   Неравномерное - движение, при котором тело за равные промежутки времени" + "\n" + "проходит неодинаковое расстояние.");
//        text5 = new TextView(myGdxGame.commonWhiteFont, 280, 234, "КРИВОЛИНЕЙНОЕ ДВИЖЕНИЕ");
//        text6 = new TextView(myGdxGame.commonWhiteFont, 30, 150, "  Вращательное - движение в одном направлении по плоской (или пространственной)" + "\n" +
//                "замкнутой траектории." + "\n" + "  Колебательное - движение, которое полностью или практически полностью" + "\n" + "повторяется с течением времени");
//        text7 = new TextView(myGdxGame.commonWhiteFont, 330, 120, "СИСТЕМА ОТСЧЁТА");
//        text8 = new TextView(myGdxGame.commonWhiteFont, 30, 70, "   Тело отсчёта - произвольно выбранное тело, относительно которого определяется" + "\n" +
//                "положение движущейся материальной точки (или тела).");
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

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen3);

            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen1);

            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();
        text3.dispose();
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

