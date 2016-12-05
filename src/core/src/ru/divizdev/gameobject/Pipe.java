package ru.divizdev.gameobject;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

/**
 * Created by znobischevdv on 29.11.2016.
 */
public class Pipe extends Scrollable {

    private Random r;

    private Rectangle skullUp, skullDown, barUp, barDown;

    private float groundY;

    private boolean isScored;

    /**
     * Getter for property 'scored'.
     *
     * @return Value for property 'scored'.
     */
    public Boolean isScored() {
        return isScored;
    }

    /**
     * Setter for property 'scored'.
     *
     * @param scored Value to set for property 'scored'.
     */
    public void setScored(Boolean scored) {
        isScored = scored;
    }

    public static final int VERTICAL_GAP = 45;
    public static final int SKULL_WIDTH = 24;
    public static final int SKULL_HEIGHT = 11;

    // Когда констуктор Pipe вызван – вызовите конструтор родителя (Scrollable)
    public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
        super(x, y, width, height, scrollSpeed);
        // Иницилизируйте объект типа Random для генерации случайных чисел
        r = new Random();

        skullUp = new Rectangle();
        skullDown = new Rectangle();
        barUp = new Rectangle();
        barDown = new Rectangle();
        this.groundY = groundY;
    }

    @Override
    public void reset(float newX) {
        // вызовите reset метод в родительском классе (Scrollable)
        super.reset(newX);
        // Измените высоту на случайное значение
        height = r.nextInt(90) + 15;
        isScored = false;
    }

    @Override
    public void update(float delta){
        super.update(delta);
        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));

        // Ширина черепа 24 пикселя. Ширина трубы всего 22 пикселя. Так что череп
        // должен быть смещен на 1 пиксель влево (так что череп будет отцентрирован
        // относительно трубы).

        // Смещение равнозначно: (SKULL_WIDTH - width) / 2
        skullUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height
                - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        skullDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);
    }

    /**
     * Getter for property 'skullUp'.
     *
     * @return Value for property 'skullUp'.
     */
    public Rectangle getSkullUp() {
        return skullUp;
    }

    /**
     * Getter for property 'skullDown'.
     *
     * @return Value for property 'skullDown'.
     */
    public Rectangle getSkullDown() {
        return skullDown;
    }

    /**
     * Getter for property 'barUp'.
     *
     * @return Value for property 'barUp'.
     */
    public Rectangle getBarUp() {
        return barUp;
    }

    /**
     * Getter for property 'barDown'.
     *
     * @return Value for property 'barDown'.
     */
    public Rectangle getBarDown() {
        return barDown;
    }

    /**
     * Getter for property 'groundY'.
     *
     * @return Value for property 'groundY'.
     */
    public float getGroundY() {
        return groundY;
    }

    public boolean collides(Bird bird) {
        if (position.x < bird.getX() + bird.getWidth()) {
            return (Intersector.overlaps(bird.getBoundingCircle(), barUp)
                    || Intersector.overlaps(bird.getBoundingCircle(), barDown)
                    || Intersector.overlaps(bird.getBoundingCircle(), skullUp) || Intersector
                    .overlaps(bird.getBoundingCircle(), skullDown));
        }
        return false;
    }

    @Override
    public void onRestart(float x, int scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }

}
