package fr.n7.game.flappyzombie.world.models;


import com.badlogic.gdx.math.Rectangle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.base.Game2DEntityGroup;

/**
 * Created by Nementon on 05/04/2015.
 */

public class GameScene extends Game2DEntityGroup {

    private Rectangle rect = new Rectangle(0,0,17,12);
    private int _worldWidth;
    private int _worldHeight;
    private Bird _bird;
    private Score _score;
    private ScrollHandler _scrollHandler;
    private List<IGame2DEntity> _child = new LinkedList<IGame2DEntity>();
    private GameState _gameState;

    private enum GameState {
        READY, RUNNING, GAMEOVER
    }

    public GameScene(int worldWidth, int worldHeight) {

        _worldWidth = worldWidth;
        _worldHeight = worldHeight;
        _bird = new Bird(33, (_worldHeight / 2) + 6, 17, 12);
        _scrollHandler = new ScrollHandler((_worldHeight /2 ) + 84);
        _score = new Score(this, _scrollHandler, _bird);

        _child.add(_scrollHandler);
        _child.add(_score);
        _child.add(_bird);
        _child.add(new GameStateHandler(this));

        _gameState = GameState.READY;
    }

    public float width(){
        return _worldWidth;
    }

    public float height() {
        return _worldHeight;
    }

    @Override
    public void update(float delta) {
        if (_gameState != GameState.READY) {
            super.update(delta);
        }

        switch (_gameState) {
            case READY:
                updateReady(delta);
                break;
            case RUNNING:
                updateRunning(delta);
                break;
            case GAMEOVER:
                updateGameOver(delta);
                break;
        }
    }

    private void updateReady(float delta) {

    }

    private void updateRunning(float delta) {
        if (_bird.isAlive() && _scrollHandler.collides(_bird)) {
            _scrollHandler.stop();
            _bird.stop();
            AssetLoader.dead.play();
            _gameState = GameState.GAMEOVER;
        }
    }

    private void updateGameOver(float delta) {
        _scrollHandler.collides(_bird);
    }

    public void start() {
        if (_gameState != GameState.RUNNING) {
            _gameState = GameState.RUNNING;
        }
        else {
            restart();
        }
    }

    public void restart() {

        _scrollHandler.restart();
        _bird.restart();
        _score.restart();
        _gameState = GameState.READY;
    }

    public boolean isReady() {
        return _gameState == GameState.READY;
    }

    public boolean isGameOver() {
        return _gameState == GameState.GAMEOVER;
    }

    @Override
    public boolean add(IGame2DEntity gameEntity) {
        return _child.add(gameEntity);
    }

    @Override
    public boolean remove(IGame2DEntity gameEntity) {
        return _child.remove(gameEntity);
    }

    public List<IGame2DEntity> child() {
        return Collections.unmodifiableList(_child);
    }

    public Bird bird() {
        return _bird;
    }

    @Override
    public float x() {
        return 0;
    }

    @Override
    public float y() {
        return 0;
    }
}
