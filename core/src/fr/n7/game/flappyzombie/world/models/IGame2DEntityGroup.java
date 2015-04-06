package fr.n7.game.flappyzombie.world.models;

import java.util.List;

/**
 * Created by Nementon on 06/04/2015.
 */
public interface IGame2DEntityGroup extends IGame2DEntity {

    boolean add(IGame2DEntity entity);

    boolean remove(IGame2DEntity entity);

    List<IGame2DEntity> child();
}
