package fr.n7.game.flappyzombie.world.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Shape2D;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.world.FlappyWorld;

/**
 * Created by Nementon on 05/04/2015.
 */
public class FlappyRenderer implements IWorldRenderer {

    private FlappyWorld _flappyWorld;
    private OrthographicCamera _camera;
    private ShapeRenderer _shapreRenderer;

    public FlappyRenderer(FlappyWorld world) {

        _flappyWorld = world;
        _camera = new OrthographicCamera();
        _shapreRenderer = new ShapeRenderer();

        _camera.setToOrtho(
                true,
                _flappyWorld.width(),
                _flappyWorld.height());
        _shapreRenderer.setProjectionMatrix(_camera.combined);
    }

    @Override
    public void render() {
        AppContext.logger().log("FlappyRenderer", "render");

        // Draw black background
        Gdx.gl.glClearColor(0, 0, 0, 10);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Draw filled shapes
        _shapreRenderer.begin(ShapeRenderer.ShapeType.Filled);
        _shapreRenderer.setColor(Color.ORANGE);
        renderWorldShape2D();

        // Draw shapes outline's
        _shapreRenderer.begin(ShapeRenderer.ShapeType.Line);
        _shapreRenderer.setColor(Color.LIGHT_GRAY);
        renderWorldShape2D();
    }

    private void renderWorldShape2D() {
        for(Shape2D shape : _flappyWorld.shapes()) {

            // TODO Improve Shape2D interface
            // libgdx, you have failed !! xD
            Rectangle rect = (Rectangle) shape;

            _shapreRenderer.rect(
                    rect.x,
                    rect.y,
                    rect.width,
                    rect.height
            );
        }

        _shapreRenderer.end();
    }
}
