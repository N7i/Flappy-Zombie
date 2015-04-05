package fr.n7.game.flappyzombie.world;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.world.models.Bird;

/**
 * Created by Nementon on 05/04/2015.
 */

public class FlappyWorld implements I2DWorld {

    private Rectangle rect = new Rectangle(0,0,17,12);
    private List<Shape2D>_shapes = new LinkedList<Shape2D>();
    private int _worldWidth;
    private int _worldHeight;
    private Bird _bird;

    public FlappyWorld(int worldWidth, int worldHeight) {

        _worldWidth = worldWidth;
        _worldHeight = worldHeight;
        _shapes.add(rect);
        _bird = new Bird(33, (_worldWidth / 2) - 6, 17, 12);
    }

    public int width(){
        return _worldWidth;
    }

    public int height() {
        return _worldHeight;
    }

    public int bounds() {
        throw new RuntimeException("Not implemented yet !");
    }

    @Override
    public void update(float delta) {
        AppContext.logger().log("FlappyWorld", "Update, fps : " + (1/delta));
        _bird.update(delta);
    }

    public Bird bird() {
        return _bird;
    }

    private boolean isYPosOutOfBounds() {
        return rect.y >= height();
    }

    private boolean isXPosOutOfBounds() {
        return rect.x >= width();
    }

    public List<Shape2D> shapes() {
        return Collections.unmodifiableList(_shapes);
    }
}
