package ru.divizdev.gameworld;

import ru.divizdev.gameobject.Bird;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameWorld {

    /**
     * Getter for property 'bird'.
     *
     * @return Value for property 'bird'.
     */
    public Bird getBird() {
        return bird;
    }

    private Bird bird;
    protected Integer fps = 0;



    public void update(float delta) {
        fps = (int)(1 / delta);
        bird.update(delta);
    }



    public Integer getFPS(){
        return fps;
    }

    public GameWorld(int midPoint) {
        bird = new Bird(33, midPoint - 5, 17, 12 );
    }
}
