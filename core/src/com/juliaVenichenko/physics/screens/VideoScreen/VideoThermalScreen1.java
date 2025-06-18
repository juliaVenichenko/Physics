package com.juliaVenichenko.physics.screens.VideoScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.video.VideoPlayer;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ImageView;

import java.io.FileNotFoundException;

public class VideoThermalScreen1 implements Screen {
    MyGdxGame myGdxGame;
    ImageView button_exit;
    ImageView button_pause;
    boolean isPlaying;

    public VideoThermalScreen1(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        this.isPlaying = true;
    }

    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        button_exit = new ImageView(5, 425, 55, 50, GameResources.BUTTON_CROSS_IMG_PATH);
        button_pause = new ImageView(70, 425, 55, 50, GameResources.BUTTON_PAUSE_IMG_PATH);

        myGdxGame.videoManager.videoPlayerThermal1.setOnCompletionListener(new VideoPlayer.CompletionListener() {
            @Override
            public void onCompletionListener(FileHandle file) {

            }
        });

        try {
            FileHandle file = Gdx.files.internal(GameResources.VIDEO_AGGREGATE_STATES);
            myGdxGame.videoManager.videoPlayerThermal1.load(file);
            myGdxGame.videoManager.videoPlayerThermal1.play();
        } catch (FileNotFoundException e){
            Gdx.app.error("gdx-video", "Oh no!");
        }

    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.videoManager.videoPlayerThermal1.update();

        myGdxGame.batch.begin();

        Texture frame = myGdxGame.videoManager.videoPlayerThermal1.getTexture();

        if(frame != null){
            myGdxGame.batch.draw(frame, 0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);
        }

        button_exit.draw(myGdxGame.batch);
        button_pause.draw(myGdxGame.batch);

        myGdxGame.batch.end();

    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (button_exit.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.videoManager.videoPlayerThermal1.stop();
                myGdxGame.setScreen(myGdxGame.thermalScreen1);
            }
            if (button_pause.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                if (isPlaying) {
                    myGdxGame.videoManager.videoPlayerThermal1.pause();
                } else {
                    myGdxGame.videoManager.videoPlayerThermal1.play();
                }
                isPlaying = !isPlaying;
            }
        }
    }

    @Override
    public void dispose() {
        if (myGdxGame.videoManager.videoPlayerThermal1 != null) {
            myGdxGame.videoManager.videoPlayerThermal1.stop(); // Остановить видео перед освобождением ресурсов
            myGdxGame.videoManager.videoPlayerThermal1.dispose();
        }
        button_exit.dispose();
        button_pause.dispose();

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
