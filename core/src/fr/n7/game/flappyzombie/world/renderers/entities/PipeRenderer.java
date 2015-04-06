package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.Pipe;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */
public class PipeRenderer implements IGame2DRenderer<Render2DContext, Pipe> {
    @Override
    public void render(Render2DContext renderContext, Pipe entity, float elapsedTime) {
        SpriteBatch batcher = renderContext.batcher();
        int middlePointY = renderContext.middlePointY();

        batcher.begin();

        batcher.draw(
                AssetLoader.bar,
                entity.x(),
                entity.y(),
                entity.width(),
                entity.height());

        batcher.draw(
                AssetLoader.bar,
                entity.x(),
                entity.y() + entity.height() + 45,
                entity.width(),
                middlePointY + 66 - (entity.height() + 45));

        batcher.draw(
                AssetLoader.skullUp,
                entity.x() - 1,
                entity.y() + entity.height() - 14, 24, 14);

        batcher.draw(
                AssetLoader.skullDown,
                entity.x() - 1,
                entity.y() + entity.height() + 45, 24, 14);

        batcher.end();
    }
}
