package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.GameStateHandler;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */
public class GameStateHandlerRenderer implements IGame2DRenderer<Render2DContext, GameStateHandler> {
    @Override
    public void render(Render2DContext renderContext, GameStateHandler entity, float elapsedTime) {
        SpriteBatch batcher = renderContext.batcher();

        if (entity.isGameReady()) {
            batcher.begin();

            AssetLoader.shadow.draw(batcher, "Touch me", (136 / 2)
                    - (42), 76);
            AssetLoader.font.draw(batcher, "Touch me", (136 / 2)
                    - (42 - 1), 75);

            batcher.end();
        }

        if (entity.isGameOver()) {
            batcher.begin();

            AssetLoader.shadow.draw(batcher, "Game Over", 25, 56);
            AssetLoader.font.draw(batcher, "Game Over", 24, 55);

            AssetLoader.shadow.draw(batcher, "Try again?", 23, 76);
            AssetLoader.font.draw(batcher, "Try again?", 24, 75);

            batcher.end();
        }
    }
}
