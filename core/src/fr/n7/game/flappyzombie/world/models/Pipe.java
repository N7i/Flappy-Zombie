package fr.n7.game.flappyzombie.world.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

import fr.n7.game.flappyzombie.world.models.base.HorizontaleScrollable;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Pipe extends HorizontaleScrollable {

    public static final int PIPE_GAP = 49;

    private Random _random;
    private Rectangle _bottomCollisionShape;

    public Pipe(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        _random = new Random();

        _bottomCollisionShape = new Rectangle(
                x,
                y + height + 45,
                width,
                Gdx.graphics.getHeight() - height + 45
        );
    }

    @Override
    public boolean collides(Bird bird) {
        if (position().x < bird.x() + bird.width()) {
            return Intersector.overlaps(
                    bird.boundingCircle(),
                    _bottomCollisionShape
            ) || super.collides(bird);
        }
        return false;
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        _bottomCollisionShape.setX(position().x);
    }

    @Override
    public void reset(float newX) {
        position().x = newX;
        height( _random.nextInt(90) + 15);
    }

    @Override
    public void height(float h) {
        float delta = height() - h;

        _bottomCollisionShape.setHeight(
                _bottomCollisionShape.getHeight() + delta);
        _bottomCollisionShape.setY(
                y() + h + 45
        );

        super.height(h);
    }


}
