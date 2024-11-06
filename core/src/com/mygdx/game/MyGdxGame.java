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
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen2;
import com.mygdx.game.screens.MechanicsScreen.MechanicsScreen3;
import com.mygdx.game.screens.MenuMechanicsScreen;
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
	public MechanicsScreen1 mechanicsScreen1;
	public MechanicsScreen2 mechanicsScreen2;
	public MechanicsScreen3 mechanicsScreen3;
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
		mechanicsScreen1 = new MechanicsScreen1(this);
		mechanicsScreen2 = new MechanicsScreen2(this);
		mechanicsScreen3 = new MechanicsScreen3(this);

		commonWhiteFont = FontBuilder.generate(25, Color.WHITE, GameResources.FONT_PATH);

		setScreen(mechanicsScreen3);

	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();

		menuScreen.dispose();
		menuScreen2.dispose();
		menuMechanicsScreen.dispose();
		mechanicsScreen1.dispose();
		mechanicsScreen2.dispose();
		mechanicsScreen3.dispose();

	}
}
