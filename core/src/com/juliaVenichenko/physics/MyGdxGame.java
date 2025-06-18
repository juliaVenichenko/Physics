package com.juliaVenichenko.physics;

import static com.juliaVenichenko.physics.GameSettings.SCR_HEIGHT;
import static com.juliaVenichenko.physics.GameSettings.SCR_WIDTH;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;
import com.juliaVenichenko.physics.managers.AudioManager;
import com.juliaVenichenko.physics.managers.VideoManager;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen1;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen10;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen11;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen12;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen13;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen14;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen15;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen16;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen17;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen18;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen19;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen2;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen20;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen21;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen22;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen3;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen4;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen5;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen6;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen7;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen8;
import com.juliaVenichenko.physics.screens.ElectricScreen.ElectricScreen9;
import com.juliaVenichenko.physics.screens.FinishScreen;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen1;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen10;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen11;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen12;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen13;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen14;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen15;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen16;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen17;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen18;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen19;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen2;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen20;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen21;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen22;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen23;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen24;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen25;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen26;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen27;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen28;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen29;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen3;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen30;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen31;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen32;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen33;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen34;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen35;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen36;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen37;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen38;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen39;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen4;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen40;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen41;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen42;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen5;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen6;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen7;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen8;
import com.juliaVenichenko.physics.screens.MechanicsScreen.MechanicsScreen9;
import com.juliaVenichenko.physics.screens.MenuElectricScreen;
import com.juliaVenichenko.physics.screens.MenuElectricScreen2;
import com.juliaVenichenko.physics.screens.MenuMechanicsScreen;
import com.juliaVenichenko.physics.screens.MenuMechanicsScreen2;
import com.juliaVenichenko.physics.screens.MenuModels3d;
import com.juliaVenichenko.physics.screens.MenuQuantumScreen;
import com.juliaVenichenko.physics.screens.MenuScreen;
import com.juliaVenichenko.physics.screens.MenuScreen2;
import com.juliaVenichenko.physics.screens.MenuTestScreen;
import com.juliaVenichenko.physics.screens.MenuThermalScreen;
//import com.mygdx.game.screens.ModelScreen.ModelWaterScreen;
import com.juliaVenichenko.physics.screens.Models3dScreen.ModelAtomScreen;
import com.juliaVenichenko.physics.screens.Models3dScreen.ModelCrystalLatticeScreen;
import com.juliaVenichenko.physics.screens.Models3dScreen.ModelTransformerScreen;
import com.juliaVenichenko.physics.screens.Models3dScreen.ModelMarsScreen;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen1;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen10;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen11;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen2;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen3;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen4;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen5;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen6;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen7;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen8;
import com.juliaVenichenko.physics.screens.QuantumScreen.QuantumScreen9;
import com.juliaVenichenko.physics.screens.QuestionScreen;
import com.juliaVenichenko.physics.screens.ScreenWarning.ScreenWarning1;
import com.juliaVenichenko.physics.screens.ScreenWarning.ScreenWarning2;
import com.juliaVenichenko.physics.screens.ScreenWarning.ScreenWarning3;
import com.juliaVenichenko.physics.screens.ScreenWarning.ScreenWarning4;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen1;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen10;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen11;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen12;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen13;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen2;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen3;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen4;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen5;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen6;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen7;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen8;
import com.juliaVenichenko.physics.screens.ThermalScreen.ThermalScreen9;
import com.juliaVenichenko.physics.screens.VideoScreen.VideoMechanicsScreen1;
import com.juliaVenichenko.physics.screens.VideoScreen.VideoThermalScreen1;
import com.juliaVenichenko.physics.screens.gpt.ChatGPT;
import com.juliaVenichenko.physics.screens.tests.testElectric.TestElectric1;
import com.juliaVenichenko.physics.screens.tests.testElectric.TestElectric2;
import com.juliaVenichenko.physics.screens.tests.testElectric.TestElectricFinish;
import com.juliaVenichenko.physics.screens.tests.testMechanics.TestMechanics1;
import com.juliaVenichenko.physics.screens.tests.testMechanics.TestMechanics2;
import com.juliaVenichenko.physics.screens.tests.testMechanics.TestMechanicsFinish;
import com.juliaVenichenko.physics.screens.tests.testQuantum.TestQuantum1;
import com.juliaVenichenko.physics.screens.tests.testQuantum.TestQuantum2;
import com.juliaVenichenko.physics.screens.tests.testQuantum.TestQuantumFinish;
import com.juliaVenichenko.physics.screens.tests.testThermal.TestThermal1;
import com.juliaVenichenko.physics.screens.tests.testThermal.TestThermal2;
import com.juliaVenichenko.physics.screens.tests.testThermal.TestThermalFinish;


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
	public MechanicsScreen34 mechanicsScreen34;
	public MechanicsScreen35 mechanicsScreen35;
	public MechanicsScreen36 mechanicsScreen36;
	public MechanicsScreen37 mechanicsScreen37;
	public MechanicsScreen38 mechanicsScreen38;
	public MechanicsScreen39 mechanicsScreen39;
	public MechanicsScreen40 mechanicsScreen40;
	public MechanicsScreen41 mechanicsScreen41;
	public MechanicsScreen42 mechanicsScreen42;

	public MenuThermalScreen menuThermalScreen;
	public ThermalScreen1 thermalScreen1;
	public ThermalScreen2 thermalScreen2;
	public ThermalScreen3 thermalScreen3;
	public ThermalScreen4 thermalScreen4;
	public ThermalScreen5 thermalScreen5;
	public ThermalScreen6 thermalScreen6;
	public ThermalScreen7 thermalScreen7;
	public ThermalScreen8 thermalScreen8;
	public ThermalScreen9 thermalScreen9;
	public ThermalScreen10 thermalScreen10;
	public ThermalScreen11 thermalScreen11;
	public ThermalScreen12 thermalScreen12;
	public ThermalScreen13 thermalScreen13;

	public MenuElectricScreen menuElectricScreen;
	public MenuElectricScreen2 menuElectricScreen2;
	public ElectricScreen1 electricScreen1;
	public ElectricScreen2 electricScreen2;
	public ElectricScreen3 electricScreen3;
	public ElectricScreen4 electricScreen4;
	public ElectricScreen5 electricScreen5;
	public ElectricScreen6 electricScreen6;
	public ElectricScreen7 electricScreen7;
	public ElectricScreen8 electricScreen8;
	public ElectricScreen9 electricScreen9;
	public ElectricScreen10 electricScreen10;
	public ElectricScreen11 electricScreen11;
	public ElectricScreen12 electricScreen12;
	public ElectricScreen13 electricScreen13;
	public ElectricScreen14 electricScreen14;
	public ElectricScreen15 electricScreen15;
	public ElectricScreen16 electricScreen16;
	public ElectricScreen17 electricScreen17;
	public ElectricScreen18 electricScreen18;
	public ElectricScreen19 electricScreen19;
	public ElectricScreen20 electricScreen20;
	public ElectricScreen21 electricScreen21;
	public ElectricScreen22 electricScreen22;

	public MenuQuantumScreen menuQuantumScreen;
	public QuantumScreen1 quantumScreen1;
	public QuantumScreen2 quantumScreen2;
	public QuantumScreen3 quantumScreen3;
	public QuantumScreen4 quantumScreen4;
	public QuantumScreen5 quantumScreen5;
	public QuantumScreen6 quantumScreen6;
	public QuantumScreen7 quantumScreen7;
	public QuantumScreen8 quantumScreen8;
	public QuantumScreen9 quantumScreen9;
	public QuantumScreen10 quantumScreen10;
	public QuantumScreen11 quantumScreen11;

	public MenuModels3d menuModels3d;
	public ModelAtomScreen modelAtomScreen;
	public ModelMarsScreen modelMarsScreen;
	public ModelCrystalLatticeScreen modelCrystalLatticeScreen;
	public ModelTransformerScreen modelTransformerScreen;

	public ScreenWarning1 screenWarning1;
	public ScreenWarning2 screenWarning2;
	public ScreenWarning3 screenWarning3;
	public ScreenWarning4 screenWarning4;

	public BitmapFont commonWhiteFont;
	public BitmapFont commonRedFont;

	public AudioManager audioManager;
	public VideoManager videoManager;


	public MenuTestScreen menuTestScreen;

	public TestMechanics1 testMechanics1;
	public TestMechanics2 testMechanics2;
	public TestMechanicsFinish testMechanicsFinish;

	public TestThermal1 testThermal1;
	public TestThermal2 testThermal2;
	public TestThermalFinish testThermalFinish;

	public TestElectric1 testElectric1;
	public TestElectric2 testElectric2;
	public TestElectricFinish testElectricFinish;

	public TestQuantum1 testQuantum1;
	public TestQuantum2 testQuantum2;
	public TestQuantumFinish testQuantumFinish;

	public ChatGPT chatGPT;

	public QuestionScreen questionScreen;

	public FinishScreen finishScreen;

	public VideoMechanicsScreen1 videoMechanicsScreen1;
	public VideoThermalScreen1 videoThermalScreen1;

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
		mechanicsScreen34 = new MechanicsScreen34(this);
		mechanicsScreen35 = new MechanicsScreen35(this);
		mechanicsScreen36 = new MechanicsScreen36(this);
		mechanicsScreen37 = new MechanicsScreen37(this);
		mechanicsScreen38 = new MechanicsScreen38(this);
		mechanicsScreen39 = new MechanicsScreen39(this);
		mechanicsScreen40 = new MechanicsScreen40(this);
		mechanicsScreen41 = new MechanicsScreen41(this);
		mechanicsScreen42 = new MechanicsScreen42(this);

		menuThermalScreen = new MenuThermalScreen(this);

		thermalScreen1 = new ThermalScreen1(this);
		thermalScreen2 = new ThermalScreen2(this);
		thermalScreen3 = new ThermalScreen3(this);
		thermalScreen4 = new ThermalScreen4(this);
		thermalScreen5 = new ThermalScreen5(this);
		thermalScreen6 = new ThermalScreen6(this);
		thermalScreen7 = new ThermalScreen7(this);
		thermalScreen8 = new ThermalScreen8(this);
		thermalScreen9 = new ThermalScreen9(this);
		thermalScreen10 = new ThermalScreen10(this);
		thermalScreen11 = new ThermalScreen11(this);
		thermalScreen12 = new ThermalScreen12(this);
		thermalScreen13 = new ThermalScreen13(this);

		menuElectricScreen = new MenuElectricScreen(this);
		menuElectricScreen2 = new MenuElectricScreen2(this);

		electricScreen1 = new ElectricScreen1(this);
		electricScreen2 = new ElectricScreen2(this);
		electricScreen3 = new ElectricScreen3(this);
		electricScreen4 = new ElectricScreen4(this);
		electricScreen5 = new ElectricScreen5(this);
		electricScreen6 = new ElectricScreen6(this);
		electricScreen7 = new ElectricScreen7(this);
		electricScreen8 = new ElectricScreen8(this);
		electricScreen9 = new ElectricScreen9(this);
		electricScreen10 = new ElectricScreen10(this);
		electricScreen11 = new ElectricScreen11(this);
		electricScreen12 = new ElectricScreen12(this);
		electricScreen13 = new ElectricScreen13(this);
		electricScreen14 = new ElectricScreen14(this);
		electricScreen15 = new ElectricScreen15(this);
		electricScreen16 = new ElectricScreen16(this);
		electricScreen17 = new ElectricScreen17(this);
		electricScreen18 = new ElectricScreen18(this);
		electricScreen19 = new ElectricScreen19(this);
		electricScreen20 = new ElectricScreen20(this);
		electricScreen21 = new ElectricScreen21(this);
		electricScreen22 = new ElectricScreen22(this);

		menuQuantumScreen = new MenuQuantumScreen(this);

		quantumScreen1 = new QuantumScreen1(this);
		quantumScreen2 = new QuantumScreen2(this);
		quantumScreen3 = new QuantumScreen3(this);
		quantumScreen4 = new QuantumScreen4(this);
		quantumScreen5 = new QuantumScreen5(this);
		quantumScreen6 = new QuantumScreen6(this);
		quantumScreen7 = new QuantumScreen7(this);
		quantumScreen8 = new QuantumScreen8(this);
		quantumScreen9 = new QuantumScreen9(this);
		quantumScreen10 = new QuantumScreen10(this);
		quantumScreen11 = new QuantumScreen11(this);

		menuModels3d = new MenuModels3d(this);
		modelAtomScreen = new ModelAtomScreen(this);
		modelMarsScreen = new ModelMarsScreen(this);
		modelCrystalLatticeScreen = new ModelCrystalLatticeScreen(this);
		modelTransformerScreen = new ModelTransformerScreen(this);

		screenWarning1 = new ScreenWarning1(this);
		screenWarning2 = new ScreenWarning2(this);
		screenWarning3 = new ScreenWarning3(this);
		screenWarning4 = new ScreenWarning4(this);


		menuTestScreen = new MenuTestScreen(this);

		testMechanics1 = new TestMechanics1(this);
		testMechanics2 = new TestMechanics2(this);
		testMechanicsFinish = new TestMechanicsFinish(this);

		testThermal1 = new TestThermal1(this);
		testThermal2 = new TestThermal2(this);
		testThermalFinish = new TestThermalFinish(this);

		testElectric1 = new TestElectric1(this);
		testElectric2 = new TestElectric2(this);
		testElectricFinish = new TestElectricFinish(this);

		testQuantum1 = new TestQuantum1(this);
		testQuantum2 = new TestQuantum2(this);
		testQuantumFinish = new TestQuantumFinish(this);

		commonWhiteFont = FontBuilder.generate(20, Color.WHITE, GameResources.FONT2_PATH);
		commonRedFont = FontBuilder.generate(20, Color.PINK, GameResources.FONT2_PATH);

		audioManager = new AudioManager();

		videoManager = new VideoManager();

		chatGPT = new ChatGPT(this);

		questionScreen = new QuestionScreen(this);

		finishScreen = new FinishScreen(this);

		videoMechanicsScreen1 = new VideoMechanicsScreen1(this);
		videoThermalScreen1 = new VideoThermalScreen1(this);

		setScreen(menuScreen);

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
		mechanicsScreen34.dispose();
		mechanicsScreen35.dispose();
		mechanicsScreen36.dispose();
		mechanicsScreen37.dispose();
		mechanicsScreen38.dispose();
		mechanicsScreen39.dispose();
		mechanicsScreen40.dispose();
		mechanicsScreen41.dispose();
		mechanicsScreen42.dispose();

		menuThermalScreen.dispose();

		thermalScreen1.dispose();
		thermalScreen2.dispose();
		thermalScreen3.dispose();
		thermalScreen4.dispose();
		thermalScreen5.dispose();
		thermalScreen6.dispose();
		thermalScreen7.dispose();
		thermalScreen8.dispose();
		thermalScreen9.dispose();
		thermalScreen10.dispose();
		thermalScreen11.dispose();
		thermalScreen12.dispose();
		thermalScreen13.dispose();

		menuElectricScreen.dispose();
		menuElectricScreen2.dispose();

		electricScreen1.dispose();
		electricScreen2.dispose();
		electricScreen3.dispose();
		electricScreen4.dispose();
		electricScreen5.dispose();
		electricScreen6.dispose();
		electricScreen7.dispose();
		electricScreen8.dispose();
		electricScreen9.dispose();
		electricScreen10.dispose();
		electricScreen11.dispose();
		electricScreen12.dispose();
		electricScreen13.dispose();
		electricScreen14.dispose();
		electricScreen15.dispose();
		electricScreen16.dispose();
		electricScreen17.dispose();
		electricScreen18.dispose();
		electricScreen19.dispose();
		electricScreen20.dispose();
		electricScreen21.dispose();
		electricScreen22.dispose();

		menuQuantumScreen.dispose();

		quantumScreen1.dispose();
		quantumScreen2.dispose();
		quantumScreen3.dispose();
		quantumScreen4.dispose();
		quantumScreen5.dispose();
		quantumScreen6.dispose();
		quantumScreen7.dispose();
		quantumScreen8.dispose();
		quantumScreen9.dispose();
		quantumScreen10.dispose();
		quantumScreen11.dispose();

		menuModels3d.dispose();
		modelAtomScreen.dispose();
		modelMarsScreen.dispose();
		modelCrystalLatticeScreen.dispose();
		modelTransformerScreen.dispose();

		screenWarning1.dispose();
		screenWarning2.dispose();
		screenWarning3.dispose();
		screenWarning4.dispose();

		menuTestScreen.dispose();

		testMechanics1.dispose();
		testMechanics2.dispose();
		testMechanicsFinish.dispose();

		testThermal1.dispose();
		testThermal2.dispose();
		testThermalFinish.dispose();

		testElectric1.dispose();
		testElectric2.dispose();
		testElectricFinish.dispose();

		testQuantum1.dispose();
		testQuantum2.dispose();
		testQuantumFinish.dispose();

		chatGPT.dispose();

		questionScreen.dispose();

		finishScreen.dispose();

		videoMechanicsScreen1.dispose();
		videoThermalScreen1.dispose();
	}
}
