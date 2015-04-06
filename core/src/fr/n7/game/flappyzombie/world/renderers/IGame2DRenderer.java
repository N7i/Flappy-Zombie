package fr.n7.game.flappyzombie.world.renderers;

import fr.n7.game.flappyzombie.world.models.IGame2DEntity;

/**
 * Created by Nementon on 06/04/2015.
 */
public interface IGame2DRenderer<C, E> {
    void render(C renderContext, E entity, float elapsedTime);
}
