package com.juliaVenichenko.physics.screens.ScreenWarning;

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
import com.juliaVenichenko.physics.components.TextView;

public class ScreenWarning3 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView button;
    private ButtonView button_back;
    private TextView text;
    private TextView text2;


    public ScreenWarning3(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);
        text = new TextView(myGdxGame.commonWhiteFont, 340, 400, "Внимание!");
        text2 = new TextView(myGdxGame.commonRedFont, 130, 300, "Для того, чтобы выйти из просмотра 3д модели," + "\n" + "нажмите на любую область ПРАВОГО КРАЯ экрана!");
        button = new ButtonView(250, 90, 290, 120, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Понятно");
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

        text.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);
        button.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.modelCrystalLatticeScreen);
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuModels3d);
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text.dispose();
        text2.dispose();
        button.dispose();
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
