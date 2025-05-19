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

public class QuestionScreen implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private ButtonView button_back;

    public QuestionScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text1 = new TextView(myGdxGame.commonWhiteFont, 220, 420, "Добро пожаловать в \"ФиzикоН\"!");
        text2 = new TextView(myGdxGame.commonRedFont, 30, 320, "В приложении вы найдёте четыре главы с теорией, формулами и" + "\n" +
                "интерактивными элементами, которые помогут легко усваивать" + "\n" + "физические концепции:");
        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 60, "Механические явления: Изучите законы движения и" + "\n" +
                "взаимодействия с анимациями и озвучкой." + "\n" + "\n" +
                "Тепловые явления: Погружение в мир температур с" + "\n" + "визуализациями и удобством прослушивания." + "\n" + "\n" +
                "Электрические явления: Узнайте о законах электричества с" + "\n" + "интерактивными иллюстрациями." + "\n" + "\n" +
                "Квантовые явления: Исследуйте загадки квантовой механики и" + "\n" + "структуры атома.");

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
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);
        text3.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.draw(myGdxGame.batch);
        text2.dispose();
        text3.dispose();

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
