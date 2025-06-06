package com.juliaVenichenko.physics.screens.gpt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.ScreenUtils;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.ImageView;

public class ChatGPT implements Screen, InputProcessor {
    MyGdxGame myGdxGame;
    private Texture background;
    private ButtonView inputField;
    private ButtonView inputFieldPink;
    private ButtonView btnSend;
    private String textUser = "";
    public static String keyUser = "";
    private String responseText = "";
    private GlyphLayout layout;
    private ImageView iconGPT;
    private ImageView key;
    private ButtonView button_back;

    private Preferences preferences;

    private float responseScrollY = 0;
    private float touchStartY = 0;

    public ChatGPT(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);

        preferences = Gdx.app.getPreferences("MyPreferences");
    }
    @Override
    public void show() {
        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        inputField = new ButtonView(25, 290, 550, 100, GameResources.INPUT_FIELD_IMG_PATH);
        inputFieldPink = new ButtonView(100, 400, 470, 50, myGdxGame.commonRedFont, GameResources.INPUT_FIELD_PINK_IMG_PATH, "Привет! Напиши свой вопрос.");
        btnSend = new ButtonView(570, 300, 210, 90, myGdxGame.commonWhiteFont, GameResources.BUTTON_IMG_PATH, "Отправить");
        iconGPT = new ImageView(25, 390, 70, 70, GameResources.BUTTON_PHUSICON_IMG_PATH);
        key = new ImageView(720, 30, 50, 50, GameResources.KEY_IMG_PATH);

        keyUser = preferences.getString("keyUser", "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");

        button_back = new ButtonView(700, 395, 65, 65, GameResources.BUTTON_BACK_2_IMG_PATH);

        layout = new GlyphLayout();

        Gdx.input.setInputProcessor(this);

    }

    @Override
    public void render(float delta) {
        handleInput();

        ScreenUtils.clear(Color.CLEAR);

        myGdxGame.camera.update();
        myGdxGame.batch.setProjectionMatrix(myGdxGame.camera.combined);

        myGdxGame.batch.begin();
        myGdxGame.batch.draw(background, 0, 0, 800, 480);
        btnSend.draw(myGdxGame.batch);
        iconGPT.draw(myGdxGame.batch);
        key.draw(myGdxGame.batch);
        inputFieldPink.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);

        drawTextField();
        drawResponseText();
        myGdxGame.batch.end();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (btnSend.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                userText();
            }
            if (button_back.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                myGdxGame.setScreen(myGdxGame.menuScreen);
                responseText = "";
            }
            if (inputField.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                showTextInputDialog();
            }
            if (key.isHit(myGdxGame.touch.x, myGdxGame.touch.y)) {
                showKeyInputDialog();
            }
        }
    }

    private void showTextInputDialog() {
        Gdx.input.getTextInput(new Input.TextInputListener() {
            @Override
            public void input(String text) {
                textUser = text;
            }

            @Override
            public void canceled() {

            }
        }, "ФизикоН", textUser, "Ваш вопрос");
    }

    private void showKeyInputDialog() {
        Gdx.input.getTextInput(new Input.TextInputListener() {
            @Override
            public void input(String text) {
                keyUser = text;

                preferences.putString("keyUser", keyUser);
                preferences.flush();

                keyUser = "";
            }

            @Override
            public void canceled() {

            }
        }, "ФизикоН", keyUser, "Введите ваш ключ");
    }

    private void drawTextField() {
        myGdxGame.batch.setColor(Color.LIGHT_GRAY);
        inputField.draw(myGdxGame.batch);
        myGdxGame.batch.setColor(Color.WHITE);

        layout.setText(myGdxGame.commonWhiteFont, textUser, Color.WHITE, 530, Align.left, true);
        myGdxGame.commonWhiteFont.draw(myGdxGame.batch, layout, 40, 380);
    }

    private void drawResponseText() {
        layout.setText(myGdxGame.commonWhiteFont, responseText, Color.WHITE, 700, Align.left, true);

        myGdxGame.commonWhiteFont.draw(myGdxGame.batch, layout, 30, 280 + responseScrollY);

    }

    private void userText() {
        NetworkTask networkTask = new NetworkTask();
        networkTask.askOpenAI(textUser, new NetworkTask.ResponseListener() {
            @Override
            public void onSuccess(String response) {
                responseText = response;
            }

            @Override
            public void onError(String error) {
                responseText = "Error: " + error;
            }
        });

        textUser = "";
    }

    @Override
    public void dispose() {
        background.dispose();
        inputField.dispose();
        btnSend.dispose();
        iconGPT.dispose();
        key.dispose();
        inputFieldPink.dispose();

        button_back.dispose();
    }

    @Override
    public boolean keyTyped(char character) {
        if (character == '\b') {
            if (textUser.length() > 0) {
                textUser = textUser.substring(0, textUser.length() - 1);
            }
        } else {
            textUser += character;
        }
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(screenX, screenY, 0));
        touchStartY = myGdxGame.touch.y;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        myGdxGame.touch = myGdxGame.camera.unproject(new Vector3(screenX, screenY, 0));
        float currentY = myGdxGame.touch.y;
        float deltaY = currentY - touchStartY;

        responseScrollY += deltaY;
        touchStartY = currentY;

        return false;
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
