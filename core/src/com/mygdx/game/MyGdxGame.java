package com.mygdx.game;

import static com.mygdx.game.GameSettings.SCR_HEIGHT;
import static com.mygdx.game.GameSettings.SCR_WIDTH;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen1;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen10;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen11;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen12;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen13;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen14;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen15;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen16;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen17;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen18;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen19;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen2;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen20;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen21;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen22;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen23;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen24;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen25;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen26;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen27;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen28;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen29;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen3;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen30;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen31;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen32;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen33;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen4;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen5;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen6;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen7;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen8;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen9;
import com.mygdx.game.screens.MenuMechanicsScreen;
import com.mygdx.game.screens.MenuMechanicsScreen2;
import com.mygdx.game.screens.MenuScreen;
import com.mygdx.game.screens.MenuScreen2;


public class MyGdxGame extends Game {
	public SpriteBatch batch;
	public World world;
	public OrthographicCamera camera;
	public Vector3 touch;
	public MenuScreen menuScreen;
	public MenuScreen2 menuScreen2;
	public MenuMechanicsScreen menuMechanicsScreen;
	public MenuMechanicsScreen2 menuMechanicsScreen2;
	public MechanicsScreen1 mechanicsScreen1;
	public MechanicsScreen2 mechanicsScreen2;
	public MechanicsScreen3 mechanicsScreen3;
	public MechanicsScreen4 mechanicsScreen4;
	public MechanicsScreen5 mechanicsScreen5;
	public MechanicsScreen6 mechanicsScreen6;
	public MechanicsScreen7 mechanicsScreen7;
	public MechanicsScreen8 mechanicsScreen8;
	public MechanicsScreen9 mechanicsScreen9;
	public MechanicsScreen10 mechanicsScreen10;
	public MechanicsScreen11 mechanicsScreen11;
	public MechanicsScreen12 mechanicsScreen12;
	public MechanicsScreen13 mechanicsScreen13;
	public MechanicsScreen14 mechanicsScreen14;
	public MechanicsScreen15 mechanicsScreen15;
	public MechanicsScreen16 mechanicsScreen16;
	public MechanicsScreen17 mechanicsScreen17;
	public MechanicsScreen18 mechanicsScreen18;
	public MechanicsScreen19 mechanicsScreen19;
	public MechanicsScreen20 mechanicsScreen20;
	public MechanicsScreen21 mechanicsScreen21;
	public MechanicsScreen22 mechanicsScreen22;
	public MechanicsScreen23 mechanicsScreen23;
	public MechanicsScreen24 mechanicsScreen24;
	public MechanicsScreen25 mechanicsScreen25;
	public MechanicsScreen26 mechanicsScreen26;
	public MechanicsScreen27 mechanicsScreen27;
	public MechanicsScreen28 mechanicsScreen28;
	public MechanicsScreen29 mechanicsScreen29;
	public MechanicsScreen30 mechanicsScreen30;
	public MechanicsScreen31 mechanicsScreen31;
	public MechanicsScreen32 mechanicsScreen32;
	public MechanicsScreen33 mechanicsScreen33;

	public BitmapFont commonWhiteFont;

	@Override
	public void create () {
		Box2D.init();
		world = new World(new Vector2(0, 0), true);
		batch = new SpriteBatch();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

		menuScreen = new MenuScreen(this);
		menuScreen2 = new MenuScreen2(this);

		menuMechanicsScreen = new MenuMechanicsScreen(this);
		menuMechanicsScreen2 = new MenuMechanicsScreen2(this);

		mechanicsScreen1 = new MechanicsScreen1(this);
		mechanicsScreen2 = new MechanicsScreen2(this);
		mechanicsScreen3 = new MechanicsScreen3(this);
		mechanicsScreen4 = new MechanicsScreen4(this);
		mechanicsScreen5 = new MechanicsScreen5(this);
		mechanicsScreen6 = new MechanicsScreen6(this);
		mechanicsScreen7 = new MechanicsScreen7(this);
		mechanicsScreen8 = new MechanicsScreen8(this);
		mechanicsScreen9 = new MechanicsScreen9(this);
		mechanicsScreen10 = new MechanicsScreen10(this);
		mechanicsScreen11 = new MechanicsScreen11(this);
		mechanicsScreen12 = new MechanicsScreen12(this);
		mechanicsScreen13 = new MechanicsScreen13(this);
		mechanicsScreen14 = new MechanicsScreen14(this);
		mechanicsScreen15 = new MechanicsScreen15(this);
		mechanicsScreen16 = new MechanicsScreen16(this);
		mechanicsScreen17 = new MechanicsScreen17(this);
		mechanicsScreen18 = new MechanicsScreen18(this);
		mechanicsScreen19 = new MechanicsScreen19(this);
		mechanicsScreen20 = new MechanicsScreen20(this);
		mechanicsScreen21 = new MechanicsScreen21(this);
		mechanicsScreen22 = new MechanicsScreen22(this);
		mechanicsScreen23 = new MechanicsScreen23(this);
		mechanicsScreen24 = new MechanicsScreen24(this);
		mechanicsScreen25 = new MechanicsScreen25(this);
		mechanicsScreen26 = new MechanicsScreen26(this);
		mechanicsScreen27 = new MechanicsScreen27(this);
		mechanicsScreen28 = new MechanicsScreen28(this);
		mechanicsScreen29 = new MechanicsScreen29(this);
		mechanicsScreen30 = new MechanicsScreen30(this);
		mechanicsScreen31 = new MechanicsScreen31(this);
		mechanicsScreen32 = new MechanicsScreen32(this);
		mechanicsScreen33 = new MechanicsScreen33(this);

		commonWhiteFont = FontBuilder.generate(20, Color.WHITE, GameResources.FONT_PATH);

		setScreen(mechanicsScreen32);

	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();

		menuScreen.dispose();
		menuScreen2.dispose();

		menuMechanicsScreen.dispose();
		menuMechanicsScreen2.dispose();

		mechanicsScreen1.dispose();
		mechanicsScreen2.dispose();
		mechanicsScreen3.dispose();
		mechanicsScreen4.dispose();
		mechanicsScreen5.dispose();
		mechanicsScreen6.dispose();
		mechanicsScreen7.dispose();
		mechanicsScreen8.dispose();
		mechanicsScreen9.dispose();
		mechanicsScreen10.dispose();
		mechanicsScreen11.dispose();
		mechanicsScreen12.dispose();
		mechanicsScreen13.dispose();
		mechanicsScreen14.dispose();
		mechanicsScreen15.dispose();
		mechanicsScreen16.dispose();
		mechanicsScreen17.dispose();
		mechanicsScreen18.dispose();
		mechanicsScreen19.dispose();
		mechanicsScreen20.dispose();
		mechanicsScreen21.dispose();
		mechanicsScreen22.dispose();
		mechanicsScreen23.dispose();
		mechanicsScreen24.dispose();
		mechanicsScreen25.dispose();
		mechanicsScreen26.dispose();
		mechanicsScreen27.dispose();
		mechanicsScreen28.dispose();
		mechanicsScreen29.dispose();
		mechanicsScreen30.dispose();
		mechanicsScreen31.dispose();
		mechanicsScreen32.dispose();
		mechanicsScreen33.dispose();

	}
}
