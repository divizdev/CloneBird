package ru.divizdev.Helpers;

import com.badlogic.gdx.InputProcessor;
import ru.divizdev.gameobject.Bird;
import ru.divizdev.gameworld.GameWorld;

/**
 * Created by znobischevdv on 27.11.2016.
 */
public class InputHandler implements InputProcessor {

    private final GameWorld myWorld;
    private Bird bird;

    public InputHandler(GameWorld myWorld) {
        this.myWorld = myWorld;
        this.bird = myWorld.getBird();
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
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (myWorld.isReady()) {
            myWorld.start();
        }

        bird.onClick();

        if (myWorld.isGameOver()) {
            // Обнулим все перменные, перейдем в GameState.READ
            myWorld.restart();
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
