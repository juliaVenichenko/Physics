package com.juliaVenichenko.physics.screens.MechanicsScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.TextView;
import com.juliaVenichenko.physics.util.AnimationUtil;

public class MechanicsScreen23 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;

    private Animation<TextureRegion> man;
    protected Array<TextureAtlas> textureAtlasArray;
    private float curTime;

    private TextureAtlas atlas;
    private float animationSpeed = 1.0f;
    private boolean isTouched = false;
    public MechanicsScreen23(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
        curTime = 0;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text1 = new TextView(myGdxGame.commonRedFont, 250, 390, "ЗАКОН ВСЕМИРНОГО ТЯГОТЕНИЯ");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 250, "Между двумя любыми материальными точками действует сила" + "\n" +
                "взаимного притяжения, прямо пропорциональная произведению" + "\n" +
                "масс этих точек, обратно пропорциональная квадрату расстояния" + "\n" +
                "между ними , направленная вдоль прямой, соединяющей" + "\n" + "материальные точки.");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
        button_sound = new ButtonView(693, 383, 75, 70, GameResources.BUTTON_SOUND_IMG_PATH);

        initAnimation();
    }

    private void initAnimation() {
        if (atlas != null) {
            atlas.dispose();
        }
        atlas = new TextureAtlas("anim3.atlas");
        man = AnimationUtil.getAnimationFromAtlas(atlas, animationSpeed);
    }

    @Override
    public void render(float delta) {
        handleInput();
        handleInputAnimation();

        ScreenUtils.clear(Color.CLEAR);

        if (isTouched) {
            curTime += delta;
        }

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);

        TextureRegion region = man.getKeyFrame(curTime, false);
        myGdxGame.batch.draw(region, 150, 20, 480f, 300f);

        button_left.draw(myGdxGame.batch);
        button_right.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);
        button_sound.draw(myGdxGame.batch);

        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_right.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen24);
                myGdxGame.audioManager.sound19.stop();
                isTouched = false;
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen22);
                myGdxGame.audioManager.sound19.stop();
                isTouched = false;
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuMechanicsScreen);
                myGdxGame.audioManager.sound19.stop();
                isTouched = false;
            }
            if (button_sound.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.audioManager.sound19.play();

            }
        }
    }

    public void handleInputAnimation() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            myGdxGame.camera.unproject(touchPos);
            if (touchPos.x >= 150 && touchPos.x <= 530 && touchPos.y >= 20 && touchPos.y <= 320) {
                curTime = 0;
                isTouched = true;
                myGdxGame.audioManager.jump.play();
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();

        myGdxGame.audioManager.sound19.dispose();
        myGdxGame.audioManager.jump.dispose();

        for (TextureAtlas atlas : textureAtlasArray) {
            atlas.dispose();
        }

        button_left.dispose();
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
