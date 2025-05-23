package com.juliaVenichenko.physics.screens.Models3dScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.JsonReader;
import com.juliaVenichenko.physics.MyGdxGame;

public class ModelCrystalLatticeScreen implements Screen {
    MyGdxGame myGdxGame;
    private Environment environment;
    private PerspectiveCamera camera;
    private CameraInputController cameraController;
    private ModelBatch modelBatch;
    private static Model model;
    private ModelInstance instance;

    public ModelCrystalLatticeScreen(MyGdxGame myGdxGame) {
        this.myGdxGame = myGdxGame;
    }
    @Override
    public void show() {

        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.8f, 0.8f, 0.8f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        modelBatch = new ModelBatch();

        camera = new PerspectiveCamera(50, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(30f, 1f, 1f);
        camera.lookAt(5, 4, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        model = new G3dModelLoader(new JsonReader()).loadModel(Gdx.files.internal("models/crystal_lattice.g3dj"));
        instance = new ModelInstance(model);

        cameraController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraController);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(camera);
        modelBatch.render(instance, environment);
        modelBatch.end();

        if (Gdx.input.justTouched()) {
            int mouseX = Gdx.input.getX();
            int mouseY = Gdx.input.getY();
            int screenWidth = Gdx.graphics.getWidth();
            int screenHeight = Gdx.graphics.getHeight();

            if (mouseX > screenWidth - 100 && mouseX < screenWidth && mouseY > 0 && mouseY < screenHeight) {
                myGdxGame.setScreen(myGdxGame.menuModels3d);
            }
        }
    }

    @Override
    public void dispose() {
        myGdxGame.batch.dispose();
        if (model != null) {
            model.dispose();
        }
        if (modelBatch != null) {
            modelBatch.dispose();
        }
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