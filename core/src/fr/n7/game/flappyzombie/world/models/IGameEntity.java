package fr.n7.game.flappyzombie.world.models;

/**
 * Created by Nementon on 06/04/2015.
 */
public interface IGameEntity {

    void update(float delta);

    float width();

    float height();
}
