package fr.n7.game.flappyzombie.logger;

import com.badlogic.gdx.Application;

/**
 * Created by Nementon on 05/04/2015.
 */

public class GDXLogger implements ILogger {

    private static String DEFAULT_APP_TAG = "FlappyZombie";
    private Application _gdxApplication;

    public GDXLogger(Application app) {
        _gdxApplication = app;
    }

    @Override
    public void log(String message) {
        log(DEFAULT_APP_TAG, message);
    }

    @Override
    public void log(String message, Throwable exception) {
        log(DEFAULT_APP_TAG, message, exception);
    }

    @Override
    public void log(String tag, String message) {
        _gdxApplication.log(tag, message);
    }

    @Override
    public void log(String tag, String message, Throwable exception) {
        _gdxApplication.log(tag, message, exception);
    }

    @Override
    public void error(String message) {
        error(DEFAULT_APP_TAG, message);
    }

    @Override
    public void error(String message, Throwable exception) {
        error(DEFAULT_APP_TAG, message, exception);
    }

    @Override
    public void error(String tag, String message) {
        _gdxApplication.error(tag, message);
    }

    @Override
    public void error(String tag, String message, Throwable exception) {
        _gdxApplication.error(tag, message, exception);
    }

    @Override
    public void debug(String message) {
        debug(DEFAULT_APP_TAG, message);
    }

    @Override
    public void debug(String message, Throwable exception) {
        debug(DEFAULT_APP_TAG, message, exception);
    }

    @Override
    public void debug(String tag, String message) {
        _gdxApplication.debug(tag, message);
    }

    @Override
    public void debug(String tag, String message, Throwable exception) {
        _gdxApplication.debug(tag, message, exception);
    }

    private void setLogLevel(int logLevel) {
        throw new RuntimeException("Not implemented yet !");
    }

    private int getLogLevel() {
        throw new RuntimeException("Not implemented yet !");
    }
}
