package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.Score;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */
public class ScoreRenderer implements IGame2DRenderer<Render2DContext, Score> {
    @Override
    public void render(Render2DContext renderContext, Score entity, float elapsedTime) {
        SpriteBatch batcher = renderContext.batcher();
        String scoreStringify = String.valueOf(entity.score());

        batcher.begin();

        AssetLoader.shadow.draw(batcher, scoreStringify, (136 / 2)
                - (3 * scoreStringify.length()), 12);
        // Draw text
        AssetLoader.font.draw(batcher, "" + scoreStringify, (136 / 2)
                - (3 * scoreStringify.length() - 1), 11);

        batcher.end();
    }
}
