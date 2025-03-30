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
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;
    public MechanicsScreen1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text2 = new TextView(myGdxGame.commonWhiteFont, 320, 400, "ВИДЫ ДВИЖЕНИЯ");
        text3 = new TextView(myGdxGame.commonRedFont, 265, 350, "ПРЯМОЛИНЕЙНОЕ ДВИЖЕНИЕ");
        text4 = new TextView(myGdxGame.commonWhiteFont, 30, 120, "Равномерное - движение, при котором тело за равные" + "\n" +
                "промежутки времени проходит одинаковое расстояние" + "\n" +
                "относительно других тел с течением времени." + "\n" +  "\n" + "\n" + "\n" +
                "Неравномерное - движение, при котором тело за равные"  + "\n" + "промежутки времени проходит неодинаковое расстояние.");
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
        button_sound = new ButtonView(693, 383, 75, 70, GameResources.BUTTON_SOUND_IMG_PATH);
    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        text2.draw(myGdxGame.batch);
        text3.draw(myGdxGame.batch);
        text4.draw(myGdxGame.batch);

        button_right.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);
        button_sound.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen2);
                myGdxGame.audioManager.sound1.stop();
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuMechanicsScreen);
                myGdxGame.audioManager.sound1.stop();
            }
            if (button_sound.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.audioManager.sound1.play();

            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text2.dispose();
        text3.dispose();
        text4.dispose();

        myGdxGame.audioManager.sound1.dispose();

        button_right.dispose();
        button_back.dispose();
        button_sound.dispose();
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
