package fr.n7.game.flappyzombie.world.renderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.image.renderable.RenderContext;

import fr.n7.game.flappyzombie.world.models.IGame2DEntity;
import fr.n7.game.flappyzombie.world.models.IGame2DEntityGroup;
import fr.n7.game.flappyzombie.world.renderers.factories.DefaultRendererFactory;
import fr.n7.game.flappyzombie.world.renderers.factories.IGame2DRendererFactory;
import fr.n7.game.flappyzombie.world.screens.DefaultScreen;

/**
 * Created by Nementon on 06/04/2015.
 */
public class Game2DRenderer implements IGame2DRenderer<Render2DContext, IGame2DEntity> {

    private IGame2DRendererFactory _factory;
    private Render2DContext _context;

    public Game2DRenderer(Render2DContext renderContext) {
        this(renderContext, new DefaultRendererFactory());
    }

    public Game2DRenderer(Render2DContext renderContext, IGame2DRendererFactory factory) {
        _context = renderContext;
        _factory = factory;
    }

    public void render(IGame2DEntity entity, float elapsedTime) {
        render(_context, entity, elapsedTime);
    }

    @Override
    public void render(Render2DContext context, IGame2DEntity entity, float elapsedTime) {
        IGame2DRenderer entityRenderer = _factory.weakInstance(entity.getClass());
        entityRenderer.render(context, entity, elapsedTime);

        if (entity instanceof IGame2DEntityGroup) {
            for (IGame2DEntity children : ((IGame2DEntityGroup) entity).child()) {
                render(context, children, elapsedTime);
            }
        }
    }

    public void dispose(){
        _factory.dispose();
    }
}
