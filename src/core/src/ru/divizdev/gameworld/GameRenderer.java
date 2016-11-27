package ru.divizdev.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.*;

/**
 * Created by znobischevdv on 11.11.2016.
 */
public class GameRenderer {
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private GameWorld myWorld;
    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 240);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {


        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

          /*
         * 1. Мы рисуем черный задний фон, чтобы избавится от моргания и следов от передвигающихся объектов
         */

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
         * 2. Мы отрисовываем однотонный квадрат
         */

        // Говорим shapeRenderer начинать отрисовывать формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Выбираем RGB Color 87, 109, 120, не прозрачный
        shapeRenderer.setColor(87 / 255.0f, 109 / 255.0f, 120 / 255.0f, 1);

        // Отрисовываем квадрат из myWorld (Используем ShapeType.Filled)
        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);

        // говорим shapeRenderer прекратить отрисовку
        // Мы ДОЛЖНЫ каждый раз это делать
        shapeRenderer.end();

        /*
         * 3. Мы отрисовываем рамку для квадрата
         */

        // Говорим shapeRenderer нарисовать рамку следующей формы
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        // Выбираем цвет RGB Color 255, 109, 120, не прозрачный
        shapeRenderer.setColor(255 / 255.0f, 0.42745098f, 120 / 255.0f, 1);

        // Отрисовываем квадрат из myWorld (Using ShapeType.Line)
        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);
        shapeRenderer.end();

        SpriteBatch spriteBatch;
        BitmapFont font;
        CharSequence str = String.valueOf(myWorld.getFPS());
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();

        spriteBatch.begin();
        font.draw(spriteBatch, str, 100, 100);
        spriteBatch.end();
    }
}
