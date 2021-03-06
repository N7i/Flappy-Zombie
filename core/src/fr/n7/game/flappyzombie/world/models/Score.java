package fr.n7.game.flappyzombie.world.models;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.helpers.AssetLoader;
import javafx.scene.Scene;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Score implements IGame2DEntity {

    private int _score;
    private ScrollHandler _scrollHandler;
    private Bird _bird;
    private Pipe _lastScored;
    private GameScene _scene;

    public Score(GameScene scene, ScrollHandler scrollHandler, Bird bird) {

        _scrollHandler = scrollHandler;
        _bird = bird;
        _scene = scene;
        _score = 0;
    }

    public void restart() {
        _lastScored = null;
        _score = 0;
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
        for(Pipe pipe : _scrollHandler.pipes()) {
            if (isPassingUnderANewPipe(pipe)) {

                AssetLoader.coin.play();
                _score++;
            }
        }
    }

    private boolean isPassingUnderANewPipe(Pipe pipe) {
        boolean result = _lastScored != pipe && Intersector.overlaps(
                _bird.boundingCircle(),
                new Rectangle(
                        pipe.x() + (pipe.width() / 2),
                        pipe.height(),
                        pipe.width() / 2,
                        45
                )
        );

        if (result) {
            _lastScored = pipe;
        }

        return result;
    }

    public int score() {
        return _score;
    }

    public GameScene scene() {
        return  _scene;
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
