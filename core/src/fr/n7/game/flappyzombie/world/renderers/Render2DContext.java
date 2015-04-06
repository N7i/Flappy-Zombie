package fr.n7.game.flappyzombie.world.renderers;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fr.n7.game.flappyzombie.world.screens.I2DScreen;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Render2DContext {

    private OrthographicCamera _camera;
    private ShapeRenderer _shapeRenderer;
    private SpriteBatch _batcher;
    private I2DScreen _screen;
    int _middlePointY;

    public Render2DContext(I2DScreen screen) {

        _screen = screen;

        _camera = new OrthographicCamera();
        _camera.setToOrtho(
                true,
                _screen.width(),
                _screen.height());

        _middlePointY = Math.round( _screen.height() / 2);
    }

    public ShapeRenderer shapeRenderer() {
        if (null == _shapeRenderer) {
            _shapeRenderer = new ShapeRenderer();
            _shapeRenderer.setProjectionMatrix(_camera.combined);
        }

        return _shapeRenderer;
    }

    public SpriteBatch batcher() {
        if (null == _batcher) {
            _batcher = new SpriteBatch();
            _batcher.setProjectionMatrix(_camera.combined);
        }

        return _batcher;
    }

    public int middlePointY() {
        return _middlePointY;
    }
}
