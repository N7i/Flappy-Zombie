package fr.n7.game.flappyzombie.world.renderers.factories;

import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

import fr.n7.game.flappyzombie.AppContext;
import fr.n7.game.flappyzombie.world.models.Bird;
import fr.n7.game.flappyzombie.world.models.GameScene;
import fr.n7.game.flappyzombie.world.models.Grass;
import fr.n7.game.flappyzombie.world.models.Pipe;
import fr.n7.game.flappyzombie.world.models.Score;
import fr.n7.game.flappyzombie.world.renderers.entities.BirdRenderer;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.entities.GameSceneRenderer;
import fr.n7.game.flappyzombie.world.renderers.entities.GrassRenderer;
import fr.n7.game.flappyzombie.world.renderers.entities.NoopRenderer;
import fr.n7.game.flappyzombie.world.renderers.entities.PipeRenderer;
import fr.n7.game.flappyzombie.world.renderers.entities.ScoreRenderer;

/**
 * Created by Nementon on 06/04/2015.
 */
public class DefaultRendererFactory implements IGame2DRendererFactory {

    private static ConcurrentHashMap<Class<?>, Class<?>> GameEntityRendererClassMap = new ConcurrentHashMap<Class<?>, Class<?>>() {
        {
            put(GameScene.class, GameSceneRenderer.class);
            put(Bird.class, BirdRenderer.class);
            put(Grass.class, GrassRenderer.class);
            put(Pipe.class, PipeRenderer.class);
            put(Score.class, ScoreRenderer.class);
        }
    };

    private static WeakHashMap<Class<?>, IGame2DRenderer> GameEntityRenderer = new WeakHashMap<Class<?>, IGame2DRenderer>();

    @Override
    public IGame2DRenderer weakInstance(Class classType) {
        IGame2DRenderer renderer = GameEntityRenderer.get(classType);
        if (null == renderer) {
            renderer = newInstance(classType);
        }

        return renderer;
    }

    public IGame2DRenderer newInstance(Class classType) {
        Class renderClass = GameEntityRendererClassMap.get(classType);

        if (null == renderClass) {
            AppContext.logger().error("No renderer found for the class "+ classType.getName());
            renderClass = NoopRenderer.class;
        }

        try {
            Object rendererInstance = renderClass.newInstance();

            if (rendererInstance instanceof IGame2DRenderer) {
                GameEntityRenderer.put(classType, (IGame2DRenderer)rendererInstance);
            }
            else {
                throw new RuntimeException("Registered renderer class for " + classType.getName() + " should implement IGame2DRenderer");
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        return GameEntityRenderer.get(classType);
    }

    public void dispose() {

    }
}
