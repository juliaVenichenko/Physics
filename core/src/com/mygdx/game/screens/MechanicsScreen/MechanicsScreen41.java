package com.mygdx.game.screens.MechanicsScreen;

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
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;
import com.mygdx.game.components.TextView;
import com.mygdx.game.util.AnimationUtil;

public class MechanicsScreen41 implements Screen {
    MyGdxGame myGdxGame;
    private Texture background;
    private TextView text1;
    private TextView text2;
    private TextView text3;
//    private ButtonView formula_21;
//    private ButtonView rectangle;
    private ButtonView button_left;
    private ButtonView button_right;
    private ButtonView button_back;
    private ButtonView button_sound;
    private Animation<TextureRegion> pendulum;
    protected Array<TextureAtlas> textureAtlasArray;
    private float timeAnimation;
    private float curTime;
    public MechanicsScreen41(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
        curTime = 0;
        timeAnimation = 0.0f;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        text1 = new TextView(myGdxGame.commonRedFont, 280, 400, "МЕХАНИЧЕСКИЕ КОЛЕБАНИЯ");
        text2 = new TextView(myGdxGame.commonWhiteFont, 30, 310, "Механические колебания - движения тел, повторяющиеся" + "\n" +
                "через одинаковые промежутки времени.");
        text3 = new TextView(myGdxGame.commonWhiteFont, 30, 230, "Период колебаний - интервал времени, через который" + "\n" + "движение повторяется.");

//        formula_21 = new ButtonView(200, 30, 400, 130, GameResources.FORMULA_21_IMG);
//        rectangle = new ButtonView(200, 30, 480, 200, GameResources.RECTANGLE);

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_right = new ButtonView(720, 20, 50, 50, GameResources.BUTTON_RIGHT_IMG_PATH);

        button_back = new ButtonView(25, 380, 70, 70, GameResources.BUTTON_BACK_IMG_PATH);
        button_sound = new ButtonView(693, 383, 75, 70, GameResources.BUTTON_SOUND_IMG_PATH);

        initAnimation();
    }
    private void initAnimation(){
        textureAtlasArray = new Array<>();
        TextureAtlas atlas = new TextureAtlas("anim1.atlas");
        pendulum = AnimationUtil.getAnimationFromAtlas(atlas, timeAnimation);
        textureAtlasArray.add(atlas);
    }

    @Override
    public void render(float delta) {
        handleInput();
        handleInputAnimation();

        ScreenUtils.clear(Color.CLEAR);

        float dTime = Gdx.graphics.getDeltaTime();
        curTime += dTime;

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();

        myGdxGame.batch.draw(background,  0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);
        text3.draw(myGdxGame.batch);

        myGdxGame.batch.draw(
                pendulum.getKeyFrame(curTime, true),
                150, 30, 480f, 200f
        );


//        formula_21.draw(myGdxGame.batch);
//        rectangle.draw(myGdxGame.batch);

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
                myGdxGame.setScreen(myGdxGame.mechanicsScreen42);
                timeAnimation = 0f;
                myGdxGame.audioManager.sound32.stop();
            }
            if (button_left.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.mechanicsScreen40);
                timeAnimation = 0f;
                myGdxGame.audioManager.sound32.stop();
            }

            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuMechanicsScreen);
                myGdxGame.audioManager.sound32.stop();
                timeAnimation = 0f;
            }
            if (button_sound.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.audioManager.sound32.play();

            }
        }
    }
    private void handleInputAnimation(){
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            myGdxGame.camera.unproject(touchPos);
            if (touchPos.x >= 150 && touchPos.x <= 530 && touchPos.y >= 30 && touchPos.y <= 230) {
                if (timeAnimation > 0f){
                timeAnimation -= 2.5f;//Math.max(0.01f, timeAnimation - 0.01f);
                initAnimation();
                }
                if (timeAnimation <= 0f){
                    timeAnimation += 2.5f;
                    initAnimation();
                }
            }
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        text1.dispose();
        text2.dispose();
        text3.dispose();

        for (TextureAtlas atlas : textureAtlasArray) {
            atlas.dispose();
        }


//        formula_21.dispose();
//        rectangle.dispose();

        button_left.dispose();
        button_right.dispose();

        myGdxGame.audioManager.sound32.dispose();

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
