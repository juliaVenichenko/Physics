package com.mygdx.game.screens.ModelScreen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MyGdxGame;

//public class ModelWaterScreen implements Screen {
//    private PerspectiveCamera camera;
//    private Model model;
//    private ModelInstance modelInstance;
//    private ModelBatch modelBatch;
//    private AssetManager assetManager;
//    private MyGdxGame myGdxGame; // ссылка на главный класс игры
//
//    public ModelWaterScreen(MyGdxGame myGdxGame) {
//        this.myGdxGame = myGdxGame; // инициализация ссылки на главный класс игры
//    }
//
//    @Override
//    public void show() {
//        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        camera.position.set(5f, 5f, 5f);
//        camera.lookAt(0, 0, 0);
//        camera.up.set(0, 1, 0);
//        camera.near = 1f;
//        camera.far = 300f;
//        camera.update();
//
//        assetManager = new AssetManager();
//        assetManager.load("models/atom_water.glb", Model.class); // Ваш файл .g3db
//        assetManager.finishLoading();
//
//        model = assetManager.get("models/atom_water.glb", Model.class);
//        modelInstance = new ModelInstance(model);
//
//        modelBatch = new ModelBatch();
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(1, 1, 1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
//
//        // Обработка ввода для вращения и увеличения
//        if (Gdx.input.isTouched()) {
//            float deltaX = Gdx.input.getDeltaX();
//            float deltaY = Gdx.input.getDeltaY();
//
//            modelInstance.transform.rotate(Vector3.Y, -deltaX * 0.5f);
//            modelInstance.transform.rotate(Vector3.X, deltaY * 0.5f);
//        }
//
//        // Увеличение/уменьшение
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
//            modelInstance.transform.scl(1.01f); // Увеличение
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
//            modelInstance.transform.scl(0.99f); // Уменьшение
//        }
//
//        // Обновление камеры
//        camera.update();
//
//        // Рендеринг модели
//        modelBatch.begin(camera);
//        modelBatch.render(modelInstance);
//        modelBatch.end();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        camera.viewportWidth = width;
//        camera.viewportHeight = height;
//        camera.update();
//    }
//
//    @Override
//    public void pause() {
//        // Реализация для приостановки, если необходимо
//    }
//
//    @Override
//    public void resume() {
//        // Реализация для возобновления, если необходимо
//    }
//
//    @Override
//    public void hide() {
//        // Реализация для скрытия экрана, если необходимо
//    }
//
//    @Override
//    public void dispose() {
//        model.dispose();
//        assetManager.dispose();
//        modelBatch.dispose();
//    }
//}
