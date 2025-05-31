package com.juliaVenichenko.physics.screens.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.juliaVenichenko.physics.GameResources;
import com.juliaVenichenko.physics.GameSettings;
import com.juliaVenichenko.physics.MyGdxGame;
import com.juliaVenichenko.physics.components.ButtonView;
import com.juliaVenichenko.physics.components.ImageView;
import com.juliaVenichenko.physics.components.TextView;

public class MainTest {
    public Texture background;
    public Texture galka;
    public ButtonView btn;
    public ButtonView button_back;
    public ImageView btnFilled1;
    public ImageView btnFilled2;
    public ImageView btnFilled3;
    public ImageView btnFilled4;
    public ImageView btnFilledNot1;
    public ImageView btnFilledNot2;
    public ImageView btnFilledNot3;
    public ImageView btnFilledNot4;
    public TextView textTask1;
    public TextView textTask2;
    public TextView textTask3;
    public TextView textTask4;
    public TextView text1;
    public TextView text2;
    public String textFieldInput = "";
    public ButtonView inputField;

    public void initializeTest(MyGdxGame myGdxGame) {
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
        galka = new Texture("galka.png");
        btn = new ButtonView(45, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Проверить");
        inputField = new ButtonView(40, 170, 300, 80, "InputField.png");

        btnFilled1 = new ImageView(360, 290, 30, 30, "button_filled.png");
        btnFilled2 = new ImageView(360, 210, 30, 30, "button_filled.png");
        btnFilled3 = new ImageView(360, 130, 30, 30, "button_filled.png");
        btnFilled4 = new ImageView(360, 50, 30, 30, "button_filled.png");

        btnFilledNot1 = new ImageView(360, 290, 30, 30, "button_filledNot.png");
        btnFilledNot2 = new ImageView(360, 210, 30, 30, "button_filledNot.png");
        btnFilledNot3 = new ImageView(360, 130, 30, 30, "button_filledNot.png");
        btnFilledNot4 = new ImageView(360, 50, 30, 30, "button_filledNot.png");

        button_back = new ButtonView(25, 390, 65, 65, GameResources.BUTTON_BACK_IMG_PATH);

    }

    public boolean isTrue(boolean isTrue){
        return isTrue;
    }

    public void drawTest(MyGdxGame myGdxGame){

        myGdxGame.batch.draw(background, 0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);

        // Рисуем фон текстового поля
        myGdxGame.batch.setColor(Color.LIGHT_GRAY);
        inputField.draw(myGdxGame.batch);
        myGdxGame.batch.setColor(Color.WHITE);

        // Рисуем текст
        myGdxGame.commonWhiteFont.draw(myGdxGame.batch, textFieldInput, 50, 210);


        textTask1.draw(myGdxGame.batch);
        textTask2.draw(myGdxGame.batch);
        textTask3.draw(myGdxGame.batch);
        textTask4.draw(myGdxGame.batch);
        text1.draw(myGdxGame.batch);
        text2.draw(myGdxGame.batch);

        btn.draw(myGdxGame.batch);

        button_back.draw(myGdxGame.batch);
    }

    public void showTextInputDialog() {
        Gdx.input.getTextInput(new Input.TextInputListener() {
            @Override
            public void input(String text) {
                textFieldInput = text; // Сохраняем введенный текст
            }

            @Override
            public void canceled() {

            }
        }, "ФизикоН", textFieldInput, "Ваш ответ");
    }

    public void disposeTest(){
        background.dispose();
        galka.dispose();
        btn.dispose();
        inputField.dispose();

        btnFilled1.dispose();
        btnFilled2.dispose();
        btnFilled3.dispose();
        btnFilled4.dispose();

        btnFilledNot1.dispose();
        btnFilledNot2.dispose();
        btnFilledNot3.dispose();
        btnFilledNot4.dispose();

        textTask1.dispose();
        textTask2.dispose();
        textTask3.dispose();
        textTask4.dispose();
        text1.dispose();
        text2.dispose();

        button_back.dispose();
    }
}

