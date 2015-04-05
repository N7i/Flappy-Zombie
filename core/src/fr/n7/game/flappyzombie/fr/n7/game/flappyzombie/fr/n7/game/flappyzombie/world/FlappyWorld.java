package fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.world;

import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.AppContext;

/**
 * Created by Nementon on 05/04/2015.
 */

public class FlappyWorld implements IWorld {

    @Override
    public void update(float delta) {

        AppContext.logger().log("FlappyWorld", "Update, fps : " + (1/delta));
    }
}
