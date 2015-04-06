package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.Bird;
import fr.n7.game.flappyzombie.world.models.IGame2DEntity;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */

public class BirdRenderer implements IGame2DRenderer<Render2DContext, Bird> {
    @Override
    public void render(Render2DContext context, Bird bird, float elapsedTime) {
        SpriteBatch batcher = context.batcher();

        batcher.begin();

        // Bird animation
        batcher.enableBlending();

        if (bird.shouldNotFlap()) {
            batcher.draw(
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
            batcher.draw(
                    AssetLoader.birdAnimation.getKeyFrame(elapsedTime),
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
        batcher.end();
    }
}
