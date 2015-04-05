package fr.n7.game.flappyzombie.world.screens;

import com.badlogic.gdx.Screen;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.world.IWorld;
import fr.n7.game.flappyzombie.world.renderers.IWorldRenderer;

/**
 * Created by Nementon on 05/04/2015.
 */
public class DefaultScreen implements Screen {

    private IWorld _world;
    private IWorldRenderer _renderer;
    private float _runTime;

    public DefaultScreen(IWorld world, IWorldRenderer worldRenderer) {

        _world = world;
        _renderer = worldRenderer;

        AppContext.logger().log("Attached");
    }

    @Override
    public void show() {
        AppContext.logger().log("Show");
    }

    @Override
    public void render(float delta) {
        _runTime += delta;

        _world.update(delta);
        _renderer.render(_runTime);
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
    }
}
