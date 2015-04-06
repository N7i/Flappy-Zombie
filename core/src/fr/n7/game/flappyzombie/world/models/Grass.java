package fr.n7.game.flappyzombie.world.models;

import fr.n7.game.flappyzombie.world.models.base.HorizontaleScrollable;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Grass extends HorizontaleScrollable {

    public Grass(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
    }

    @Override
    public void reset(float newX) {
        position().x = newX;
    }
}
