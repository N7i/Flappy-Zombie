package fr.n7.game.flappyzombie.world.renderers.entities;

import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 06/04/2015.
 */
public class NoopRenderer implements IGame2DRenderer<Render2DContext, Object> {
    @Override
    public void render(Render2DContext renderContext, Object entity, float elapsedTime) {
    }
}
