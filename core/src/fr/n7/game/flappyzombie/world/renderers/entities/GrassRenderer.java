package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.Grass;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */
public class GrassRenderer implements IGame2DRenderer<Render2DContext, Grass> {
    @Override
    public void render(Render2DContext renderContext, Grass entity, float elapsedTime) {
        SpriteBatch batcher = renderContext.batcher();

        batcher.begin();

        batcher.draw(
                AssetLoader.grass,
                entity.x(),
                entity.y(),
                entity.width(),
                entity.height());

        batcher.end();
    }
}
