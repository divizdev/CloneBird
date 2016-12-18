package ru.divizdev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import ru.divizdev.Helpers.InputHandler;
import ru.divizdev.gameworld.GameRenderer;
import ru.divizdev.gameworld.GameWorld;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;

    public GameScreen(){

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) gameHeight / 2;


        world = new GameWorld(midPointY); // initialize world
        Gdx.input.setInputProcessor(new InputHandler(world, screenWidth / gameWidth, screenHeight / gameHeight));

        renderer = new GameRenderer(world, (int)gameHeight, midPointY); // initialize renderer



    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show");
    }

    @Override
    public void render(float delta) {

        runTime += delta;
        world.update(delta); // GameWorld updates
        renderer.render(delta, runTime); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "Resize");

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "Pause");

    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "Resume");

    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "Hide");
    }

    @Override
    public void dispose() {
//        Gdx.app.log("GameScreen", "Dispose");


    }
}
