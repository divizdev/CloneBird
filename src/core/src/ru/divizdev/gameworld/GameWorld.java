package ru.divizdev.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameWorld {

    private Rectangle rect = new Rectangle(0, 0, 17, 12);



    public void update(float delta) {
        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        rect.x++;
        if (rect.x > 137) {
            rect.x = 0;
        }
    }

    public Rectangle getRect(){
        return rect;
    }
}
