package fr.n7.game.flappyzombie.world.models.base;

import fr.n7.game.flappyzombie.world.models.IGame2DEntity;
import fr.n7.game.flappyzombie.world.models.IGame2DEntityGroup;

/**
 * Created by Nementon on 06/04/2015.
 */
public abstract class Game2DEntityGroup implements IGame2DEntityGroup {

    @Override
    public void update(float delta) {
        for(IGame2DEntity children : child()) {
            children.update(delta);
        }
    }
}
