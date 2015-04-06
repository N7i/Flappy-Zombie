package fr.n7.game.flappyzombie;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.helpers.InputHandler;
import fr.n7.game.flappyzombie.world.models.GameScene;
import fr.n7.game.flappyzombie.world.screens.DefaultScreen;

public class FlappyGame extends Game {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        AppContext.logger().log("Created");

        AssetLoader.load();

        GameScene world = new GameScene(136, 204);
        setScreen(new DefaultScreen(world));
        Gdx.input.setInputProcessor(new InputHandler(world.bird()));
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
