package fr.n7.game.flappyzombie;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.helpers.InputHandler;
import fr.n7.game.flappyzombie.world.renderers.FlappyRenderer;
import fr.n7.game.flappyzombie.world.FlappyWorld;
import fr.n7.game.flappyzombie.world.screens.DefaultScreen;

public class FlappyGame extends Game {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        AppContext.logger().log("Created");

        AssetLoader.load();

        FlappyWorld world = new FlappyWorld(136, 204);
        FlappyRenderer worldRenderer = new FlappyRenderer(world);

        setScreen(new DefaultScreen(
                world,
                worldRenderer
        ));

        Gdx.input.setInputProcessor(new InputHandler(world.bird()));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
