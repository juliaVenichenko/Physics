package com.mygdx.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;

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
    private ButtonView button_ten;
    private ButtonView button_eleven;
    private ButtonView button_twelve;
    private ButtonView button_thirteen;
    private ButtonView button_fourteen;
    private ButtonView button_fifteen;

    public MenuMechanicsScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        button_one = new ButtonView(25, 380, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "1. Виды движения");
        button_two = new ButtonView(275, 380, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "2. Масса тела");
        button_three = new ButtonView(515, 380, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "3. Сила");
        button_four = new ButtonView(25, 290, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "4. Инерция");
        button_five = new ButtonView(275, 290, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "5. Сила трения");
        button_six = new ButtonView(515, 290, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "6. Деформация");
        button_seven = new ButtonView(25, 200, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "7. Сила притяжения");
        button_eight = new ButtonView(248, 200, 285, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "8. Закон сохранения импульса");
        button_nine = new ButtonView(515, 200, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "9. Механическая работа");
        button_ten = new ButtonView(25, 110, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "10. Виды энергии");
        button_eleven = new ButtonView(275, 110, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "11. Простые механизмы");
        button_twelve = new ButtonView(515, 110, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "12. Давление");
        button_thirteen = new ButtonView(25, 20, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "13. Закон Паскаля");
        button_fourteen = new ButtonView(275, 20, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_VIOLET_IMG_PATH, "14. Закон Архимеда");
        button_fifteen = new ButtonView(515, 20, 240, 70, myGdxGame.commonWhiteFont, GameResources.BUTTON_BLUE_IMG_PATH, "15. Звук");

    }

    @Override
    public void render(float delta) {
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
        button_ten.draw(myGdxGame.batch);
        button_eleven.draw(myGdxGame.batch);
        button_twelve.draw(myGdxGame.batch);
        button_thirteen.draw(myGdxGame.batch);
        button_fourteen.draw(myGdxGame.batch);
        button_fifteen.draw(myGdxGame.batch);

        myGdxGame.batch.end();
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
        button_ten.dispose();
        button_eleven.dispose();
        button_twelve.dispose();
        button_thirteen.dispose();
        button_fourteen.dispose();
        button_fifteen.dispose();

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
