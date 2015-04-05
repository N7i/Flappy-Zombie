package fr.n7.game.flappyzombie;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.world.FlappyRenderer;
import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.world.FlappyWorld;
import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.screens.DefaultScreen;

public class FlappyGame extends Game {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        AppContext.logger().log("Created");

        FlappyWorld world = new FlappyWorld(136, 204);
        FlappyRenderer worldRenderer = new FlappyRenderer(world);

        setScreen(new DefaultScreen(
                world,
                worldRenderer
        ));
    }
}
