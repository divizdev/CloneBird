package ru.divizdev.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import ru.divizdev.Helpers.InputHandler;
import ru.divizdev.gameworld.GameRenderer;
import ru.divizdev.gameworld.GameWorld;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;

    public GameScreen(){

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int) gameHeight / 2;


        world = new GameWorld(midPointY); // initialize world
        renderer = new GameRenderer(world); // initialize renderer

        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));
    }

    @Override
    public void show() {
        Gdx.app.log("GameScreen", "Show");
    }

    @Override
    public void render(float delta) {
        // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f);
        // Fills the screen with the selected color
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.update(delta); // GameWorld updates
        renderer.render(); // GameRenderer renders
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
