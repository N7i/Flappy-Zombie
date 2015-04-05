package fr.n7.game.flappyzombie.world.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.FlappyWorld;
import fr.n7.game.flappyzombie.world.models.Bird;

/**
 * Created by Nementon on 05/04/2015.
 */
public class FlappyRenderer implements IWorldRenderer {

    private FlappyWorld _flappyWorld;
    private OrthographicCamera _camera;
    private ShapeRenderer _shapeRenderer;
    private SpriteBatch _batcher;
    private int _middlePointY;

    public FlappyRenderer(FlappyWorld world) {

        _flappyWorld = world;
        _camera = new OrthographicCamera();
        _shapeRenderer = new ShapeRenderer();
        _batcher = new SpriteBatch();

        _camera.setToOrtho(
                true,
                _flappyWorld.width(),
                _flappyWorld.height());
        _shapeRenderer.setProjectionMatrix(_camera.combined);
        _batcher.setProjectionMatrix(_camera.combined);

        _middlePointY = _flappyWorld.height() / 2;
    }

    @Override
    public void render(float runTime) {
        AppContext.logger().log("FlappyRenderer", "render");

        resetScreenWithBlackColor();
        renderShapes();
        renderSprites(runTime);

    }

    private void resetScreenWithBlackColor() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void renderShapes() {

        _shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        _shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        _shapeRenderer.rect(0, 0, 136, _middlePointY + 66);

        // Draw Grass
        _shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        _shapeRenderer.rect(0, _middlePointY + 66, 136, 11);

        // Draw Dirt
        _shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        _shapeRenderer.rect(0, _middlePointY + 77, 136, 52);

        // End ShapeRenderer
        _shapeRenderer.end();
    }

    private void renderSprites(float runTime) {
        Bird bird = _flappyWorld.bird();

        _batcher.begin();

        // Background
        _batcher.disableBlending();
        _batcher.draw(AssetLoader.bg, 0, _middlePointY + 23, 136, 43);

        // Bird animation
        _batcher.enableBlending();

        if (bird.shouldNotFlap()) {
            _batcher.draw(
                    AssetLoader.bird,
                    bird.x(),
                    bird.y(),
                    bird.width() / 2.0f,
                    bird.height() / 2.0f,
                    bird.width(),
                    bird.height(),
                    1,
                    1,
                    bird.rotation());
        }
        else {
            _batcher.draw(
                    AssetLoader.birdAnimation.getKeyFrame(runTime),
                    bird.x(),
                    bird.y(),
                    bird.width() / 2.0f,
                    bird.height() / 2.0f,
                    bird.width(),
                    bird.height(),
                    1,
                    1,
                    bird.rotation());
        }
        _batcher.end();
    }
}
