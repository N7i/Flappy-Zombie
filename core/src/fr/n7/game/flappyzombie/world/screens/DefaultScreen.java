package fr.n7.game.flappyzombie.world.screens;

import com.badlogic.gdx.Gdx;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.world.models.GameScene;
import fr.n7.game.flappyzombie.world.renderers.Game2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 05/04/2015.
 */
public class DefaultScreen implements I2DScreen {

    private GameScene _gameScene;
    private Game2DRenderer _renderer;
    private float _elapsedTime;

    public DefaultScreen(GameScene scene) {

        _gameScene = scene;
        _renderer = new Game2DRenderer(
                new Render2DContext(this));

        AppContext.logger().log("Attached");
    }

    public float width() {
        return 136;
    }

    public float height() {
        return Gdx.graphics.getHeight() / ( Gdx.graphics.getWidth() / width() );
    }

    @Override
    public void show() {
        AppContext.logger().log("Show");
    }

    @Override
    public void render(float delta) {
        _elapsedTime += delta;

        _gameScene.update(delta);
        _renderer.render(_gameScene, _elapsedTime);
    }

    @Override
    public void resize(int width, int height) {
        AppContext.logger().log("Resize");
    }

    @Override
    public void pause() {
        AppContext.logger().log("pause");
    }

    @Override
    public void resume() {
        AppContext.logger().log("resume");
    }

    @Override
    public void hide() {
        AppContext.logger().log("hide");
    }

    @Override
    public void dispose() {

        AppContext.logger().log("Dispose");
        _renderer.dispose();
    }
}
