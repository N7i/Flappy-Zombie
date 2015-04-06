package fr.n7.game.flappyzombie.world.models;

/**
 * Created by Nementon on 06/04/2015.
 */
public class GameStateHandler implements IGame2DEntity {

    private GameScene _scene;

    public GameStateHandler(GameScene scene) {
        _scene = scene;
    }

    public boolean isGameOver() {
        return _scene.isGameOver();
    }

    public boolean isGameReady() {
        return _scene.isReady();
    }

    @Override
    public float x() {
        return 0;
    }

    @Override
    public float y() {
        return 0;
    }

    @Override
    public void update(float delta) {
    }

    @Override
    public float width() {
        return 0;
    }

    @Override
    public float height() {
        return 0;
    }
}
