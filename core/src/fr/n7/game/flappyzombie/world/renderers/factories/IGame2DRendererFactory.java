package fr.n7.game.flappyzombie.world.renderers.factories;

import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;

/**
 * Created by Nementon on 06/04/2015.
 */
public interface IGame2DRendererFactory {

    IGame2DRenderer weakInstance(Class classType);
    void dispose();

}
