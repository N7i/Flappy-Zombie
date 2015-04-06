package fr.n7.game.flappyzombie.world.models.base;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


import fr.n7.game.flappyzombie.world.models.Bird;
import fr.n7.game.flappyzombie.world.models.IGame2DEntity;

/**
 * Created by Nementon on 06/04/2015.
 */
public abstract class HorizontaleScrollable implements IGame2DEntity {

    private Vector2 _position;
    private Vector2 _velocity;
    private float _width;
    private float _height;
    private Rectangle _collisionShape;

    private float _initX;
    private float _initSpeed;

    public HorizontaleScrollable(float x, float y, int width, int height, float scrollSpeed) {
        _position = new Vector2(x, y);
        _velocity = new Vector2(scrollSpeed, 0);
        _width = width;
        _height = height;

        _collisionShape = new Rectangle(
                _position.x,
                _position.y,
                _width,
                _height

        );

        _initX = x;
        _initSpeed = scrollSpeed;
    }

    public boolean collides(Bird bird) {
        if (_position.x < bird.x() + bird.width()) {
            return Intersector.overlaps(
                    bird.boundingCircle(),
                    _collisionShape
            );
        }
        return  false;
    }

    public void stop() {
        _velocity.x = 0;
    }

    public void update(float delta) {
        _position.add(_velocity.cpy().scl(delta));
        _collisionShape.setX(_position.x);
    }

    public  void restart() {
        _position.x = _initX;
        _velocity.x = _initSpeed;
    }

    public abstract void reset(float newX);

    public boolean isScrolledLeft() {
        return _position.x + _width < 0;
    }

    public float tailX() {
        return _position.x + _width;
    }

    public float x() {
        return _position.x;
    }

    public float y() {
        return _position.y;
    }

    public float width() {
        return _width;
    }

    protected void width(float w) {
        _width = w;
        _collisionShape.setWidth(w);
    }

    public float height() {
        return _height;
    }

    protected  void height(float h) {
        _height = h;
        _collisionShape.setHeight(h);
    }

    protected Vector2 position() {
        return _position;
    }

    protected  Vector2 velocity() {
        return _velocity;
    }

}
