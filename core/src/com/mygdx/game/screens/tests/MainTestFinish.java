package com.mygdx.game.screens.tests;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameResources;
import com.mygdx.game.GameSettings;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.components.ButtonView;
import com.mygdx.game.components.TextView;

public class MainTestFinish {
    public Texture background;
    public ButtonView btnResult;
    public ButtonView btnAgain;
    public ButtonView button_left;
    public ButtonView button_back;
    public TextView text1;
    public TextView text2;
    public TextView text3;
    public TextView textResult;

    public void initializeTestFinish(MyGdxGame myGdxGame, int score) {
        background = new Texture(GameResources.BACKGROUND_DOSKA_IMG_PATH);
        btnResult = new ButtonView(120, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Показать результат");
        btnAgain = new ButtonView(400, 60, 280, 100, myGdxGame.commonWhiteFont, "button.png", "Пройти заново");

        text1 = new TextView(myGdxGame.commonRedFont, 30, 260, "Поздравляю! Ты отлично справился с тестом, а значит хорошо" + "\n" +
                "усвоил материал! Продолжай в том же духе!");

        text2 = new TextView(myGdxGame.commonRedFont, 30, 260, "Неплохо! Ты уже многое знаешь, но иногда ошибаешься." + "\n" +
                "Повтори материал и пройди тест заново. У тебя всё получится!");

        text3 = new TextView(myGdxGame.commonRedFont, 30, 260, "Ты можешь лучше! Я в тебя верю! Повтори теорию ещё раз и" + "\n" +
                "возвращайся к тесту с восполненными знаниями!");

        textResult = new TextView(myGdxGame.commonRedFont, 280, 390, "Твой результат: " + score + " из 4!");

        button_left = new ButtonView(30, 20, 50, 50, GameResources.BUTTON_LEFT_IMG_PATH);
        button_back = new ButtonView(25, 390, 65, 65, GameResources.BUTTON_BACK_IMG_PATH);
    }

    public void drawTestFinish(MyGdxGame myGdxGame){
        myGdxGame.batch.draw(background, 0, 0, GameSettings.SCR_WIDTH, GameSettings.SCR_HEIGHT);

        btnResult.draw(myGdxGame.batch);
        btnAgain.draw(myGdxGame.batch);

        button_left.draw(myGdxGame.batch);
        button_back.draw(myGdxGame.batch);
    }

    public void disposeTestFinish(){
        background.dispose();

        btnResult.dispose();
        btnAgain.dispose();

        textResult.dispose();

        text1.dispose();
        text2.dispose();
        text3.dispose();

        button_left.dispose();
        button_back.dispose();
    }

}
