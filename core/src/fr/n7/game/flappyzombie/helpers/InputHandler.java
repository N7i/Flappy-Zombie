package fr.n7.game.flappyzombie.helpers;

import com.badlogic.gdx.InputProcessor;

import fr.n7.game.flappyzombie.world.models.Bird;

/**
 * Created by Nementon on 05/04/2015.
 */
public class InputHandler implements InputProcessor {

    Bird _bird;

    public InputHandler(Bird bird) {

        _bird = bird;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        _bird.onClick();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
