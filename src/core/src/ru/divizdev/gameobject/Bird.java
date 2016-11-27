package ru.divizdev.gameobject;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by znobischevdv on 27.11.2016.
 */
public class Bird {

    public Bird(Vector2 position, Vector2 velocity, Vector2 acceleration, float rotation, int width, int height) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.rotation = rotation;
        this.width = width;
        this.height = height;
    }

    public Bird(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = new Vector2(x, y);
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 460);
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
        position.add(velocity.cpy().scl(delta));
    }

    public void onClick(){
        velocity.y -= 140;
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

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private float rotation;
    private int width;
    private int height;
}
