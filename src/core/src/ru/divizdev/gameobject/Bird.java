package ru.divizdev.gameobject;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import ru.divizdev.Helpers.AssetLoader;

/**
 * Created by znobischevdv on 27.11.2016.
 */
public class Bird {

    private Circle boundingCircle;
    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;
    private float rotation;
    private int width;
    private int height;
    private boolean isAlive = true;

    private float originalY;


    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 220);
        boundingCircle = new Circle();
        this.originalY = y;
    }

    /**
     * Getter for property 'boundingCircle'.u
     *
     * @return Value for property 'boundingCircle'.
     */
    public Circle getBoundingCircle() {
        return boundingCircle;
    }

    public  float getX(){
        return position.x;
    }

    public float getY(){
        return  position.y;
    }

    public void update(float delta) {
        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        // проверяем потолок
        if (position.y < -13) {
            position.y = -13;
            velocity.y = 0;
        }

        position.add(velocity.cpy().scl(delta));

        // Устанавливаем центр круга (9, 6) по отношению к птице.
        // Устанавливаем радиус круга равным 6.5f;
        boundingCircle.set(position.x + 9, position.y + 6, 6.5f);

        // Повернем против часовой стрелки
        if (velocity.y < 0) {
            rotation -= 600 * delta;

            if (rotation < -20) {
                rotation = -20;
            }
        }

        // Повернем по часовой стрелке
        if (isFalling() || !isAlive) {
            rotation += 480 * delta;
            if (rotation > 90) {
                rotation = 90;
            }
        }
    }

    public void updateReady(float runTime) {
        position.y = 2 * (float) Math.sin(7 * runTime) + originalY;
    }

    public void onClick(){
        if (isAlive) {
            AssetLoader.flap.play();
            velocity.y -= 120;
        }
    }



    public boolean isFalling(){
        return velocity.y > 150;
    }

    public boolean shouldntFlap(){
        return velocity.y > 70 || !isAlive;
    }

    /**
     * Getter for property 'position'.
     *
     * @return Value for property 'position'.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Getter for property 'velocity'.
     *
     * @return Value for property 'velocity'.
     */
    public Vector2 getVelocity() {
        return velocity;
    }

    /**
     * Getter for property 'acceleration'.
     *
     * @return Value for property 'acceleration'.
     */
    public Vector2 getAcceleration() {
        return acceleration;
    }

    /**
     * Getter for property 'rotation'.
     *
     * @return Value for property 'rotation'.
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * Getter for property 'width'.
     *
     * @return Value for property 'width'.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Getter for property 'height'.
     *
     * @return Value for property 'height'.
     */
    public int getHeight() {
        return height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
        velocity.y = 0;
    }

    public void decelerate() {
        acceleration.y = 0;
    }

    public void onRestart(int y) {
        rotation = 0;
        position.y = y;
        velocity.x = 0;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 460;
        isAlive = true;
    }
}
