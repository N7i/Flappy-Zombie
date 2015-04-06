package fr.n7.game.flappyzombie.world.models;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

import fr.n7.game.flappyzombie.helpers.AssetLoader;

/**
 * Created by Nementon on 05/04/2015.
 */
public class Bird implements IGame2DEntity {

    private final int MAX_VELOCITY = 200;
    private final int MIN_ROTATION_ANGLE = -20;
    private final int MAX_ROTATION_ANGLE = 90;

    private Vector2 _position,
                    _velocity,
                    _acceleration;
    private int _width,
                _height;
    private float _rotation;
    private Circle _boundingCircle;
    private boolean _isAlive;

    private float _initPosY;
    private final int _initAccelerationY = 460;

    public Bird(float posX, float posY, int width, int height) {

        _initPosY = posY;
        _position = new Vector2(posX, posY);
        _velocity = new Vector2(0,0);
        _acceleration = new Vector2(0, _initAccelerationY);
        _width = width;
        _height = height;
        _isAlive = true;
        _boundingCircle = new Circle();
    }

    public void restart() {
        _rotation = 0;
        _position.y = _initPosY;
        _velocity.x = 0;
        _velocity.y = 0;
        _acceleration.x = 0;
        _acceleration.y = _initAccelerationY;
        _isAlive = true;
    }

    public void update(float delta) {
        _velocity.add(_acceleration.cpy().scl(delta));
        if (_velocity.y > MAX_VELOCITY) {
            _velocity.y = MAX_VELOCITY;
        }

        _position.add(_velocity.cpy().scl(delta));
        _boundingCircle.set(_position.x + 9, _position.y + 6, 6.5f);
        // Rotate counterclockwise
        if (isFlapping()) {
            _rotation -= 600 * delta;

            if (_rotation < MIN_ROTATION_ANGLE) {
                _rotation = MIN_ROTATION_ANGLE;
            }
        }

        // Rotate clockwise
        if (isFalling()) {
            _rotation += 480 * delta;
            if (_rotation > MAX_ROTATION_ANGLE) {
                _rotation = MAX_ROTATION_ANGLE;
            }


        }
    }

    private boolean isFlapping() {
        return _velocity.y < 0;
    }

    public boolean isFalling() {
        return _velocity.y > 110;
    }

    public boolean shouldNotFlap() {
        return _velocity.y > 70;
    }

    public void onClick() {
        if (_isAlive) {
            AssetLoader.flap.play();
            _velocity.y = -140;
        }
    }

    public void stop() {
        _isAlive = false;
    }

    public void die() {
        _velocity.y = 0;
        _acceleration.y = 0;
    }

    public float x() {
        return _position.x;
    }

    public float y(){
        return _position.y;
    }

    public float width() {
        return _width;
    }

    public float height() {
        return _height;
    }

    public float rotation() {
        return _rotation;
    }

    public Circle boundingCircle() {
        return _boundingCircle;
    }

    public boolean isAlive() {
        return _isAlive;
    }
}
