package ru.divizdev.gameworld;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameWorld {

    private Rectangle rect = new Rectangle(0, 10, 17, 12);
    protected Integer fps = 0;



    public void update(float delta) {
//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        fps = (int)(1 / delta);
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect(){
        return rect;
    }

    public Integer getFPS(){
        return fps;
    }
}
