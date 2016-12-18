package ru.divizdev.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import ru.divizdev.Helpers.AssetLoader;
import ru.divizdev.gameobject.Bird;
import ru.divizdev.gameobject.ScrollHandler;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameWorld {

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public int getMidPoint() {
        return midPoint;
    }

    public boolean isMenu() {
        return currentState == GameState.MENU;
    }

    public void ready() {
        currentState = GameState.READY;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }

    public enum GameState {
        MENU, READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    protected Integer fps = 0;
    private ScrollHandler scroller;
    private Bird bird;
    private boolean isAlive = true;
    private Rectangle ground;
    private int score = 0;
    private GameState currentState;
    public int midPoint;



    public GameWorld(int midPoint) {
        bird = new Bird(33, midPoint - 5, 17, 12);
        scroller = new ScrollHandler(this, midPoint + 66);
        ground = new Rectangle(0, midPoint + 66, 136, 11);
        currentState = GameState.READY;
        this.midPoint = midPoint;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int increment) {
        score += increment;
    }

    public ScrollHandler getScroller() {
        return scroller;
    }

    /**
     * Getter for property 'bird'.
     *
     * @return Value for property 'bird'.
     */
    public Bird getBird() {
        return bird;
    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            case GAMEOVER:
                break;
        }



    }

    private void updateReady(float delta) {

    }

    private void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        fps = (int) (1 / delta);
        bird.update(delta);
        scroller.update(delta);

        if (scroller.collides(bird) && bird.isAlive()) {
            scroller.stop();
            bird.die();
            AssetLoader.dead.play();
        }


        if (Intersector.overlaps(bird.getBoundingCircle(), ground)) {
            scroller.stop();
            bird.die();
            bird.decelerate();
            currentState = GameState.GAMEOVER;

            if (score > AssetLoader.getHighScore()) {
                AssetLoader.setHighScore(score);
                currentState = GameState.HIGHSCORE;
            }
        }
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public Integer getFPS() {
        return fps;
    }

    public boolean isReady() {
        return (currentState == GameState.READY);
    }

    public void start(){
        currentState = GameState.RUNNING;
    }

    public void restart() {
        currentState = GameState.READY;
        score = 0;
        bird.onRestart(midPoint - 5);
        scroller.onRestart();
        currentState = GameState.READY;
    }
}
