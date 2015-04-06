package fr.n7.game.flappyzombie.world.models.base;

import com.badlogic.gdx.math.Vector2;

import fr.n7.game.flappyzombie.world.models.IGame2DEntity;

/**
 * Created by Nementon on 06/04/2015.
 */
public abstract class HorizontaleScrollable implements IGame2DEntity {

    private Vector2 _position;
    private Vector2 _velocity;
    private float _width;
    private float _height;

    public HorizontaleScrollable(float x, float y, int width, int height, float scrollSpeed) {
        _position = new Vector2(x, y);
        _velocity = new Vector2(scrollSpeed, 0);
        _width = width;
        _height = height;
    }

    public void update(float delta) {
        _position.add(_velocity.cpy().scl(delta));
    }

    // Reset: Should Override in subclass for more specific behavior.
    public abstract void reset(float newX);

    // Getters for instance variables
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
    }

    public float height() {
        return _height;
    }

    protected  void height(float h) {
        _height = h;
    }

    protected Vector2 position() {
        return _position;
    }

    protected  Vector2 velocity() {
        return _velocity;
    }

}
