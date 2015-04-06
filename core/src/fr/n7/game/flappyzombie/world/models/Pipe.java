package fr.n7.game.flappyzombie.world.models;

import java.util.Random;

import fr.n7.game.flappyzombie.world.models.base.HorizontaleScrollable;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Pipe extends HorizontaleScrollable {

    public static final int PIPE_GAP = 49;

    private Random _random;

    public Pipe(float x, float y, int width, int height, float scrollSpeed) {
        super(x, y, width, height, scrollSpeed);
        _random = new Random();
    }

    @Override
    public void reset(float newX) {
        position().x = newX;
        height( _random.nextInt(90) + 15);
    }


}
