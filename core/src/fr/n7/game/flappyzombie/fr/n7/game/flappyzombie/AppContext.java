package fr.n7.game.flappyzombie.fr.n7.game.flappyzombie;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.logger.GDXLogger;
import fr.n7.game.flappyzombie.fr.n7.game.flappyzombie.logger.ILogger;

/**
 * Created by Nementon on 05/04/2015.
 */
public class AppContext {

    private static ILogger Logger;

    public static ILogger logger(){
        if (null == AppContext.Logger) {
            AppContext.Logger = new GDXLogger(Gdx.app);
        }
        return AppContext.Logger;
    }
}
