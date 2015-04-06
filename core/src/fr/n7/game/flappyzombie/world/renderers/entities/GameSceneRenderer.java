package fr.n7.game.flappyzombie.world.renderers.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import fr.n7.game.flappyzombie.helpers.AssetLoader;
import fr.n7.game.flappyzombie.world.models.GameScene;
import fr.n7.game.flappyzombie.world.renderers.IGame2DRenderer;
import fr.n7.game.flappyzombie.world.renderers.Render2DContext;

/**
 * Created by Nementon on 05/04/2015.
 */
public class GameSceneRenderer implements IGame2DRenderer<Render2DContext, GameScene> {

    @Override
    public void render(Render2DContext context, GameScene scene, float elapsedTime) {
        resetScreenWithBlackColor();
        renderShapes(context);
    }

    private void resetScreenWithBlackColor() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void renderShapes(Render2DContext context) {
        ShapeRenderer shapeRenderer = context.shapeRenderer();
        SpriteBatch batcher = context.batcher();
        int middlePointY = context.middlePointY();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        shapeRenderer.rect(0, 0, 136, middlePointY + 66);

        // Draw Grass
        shapeRenderer.setColor(111 / 255.0f, 186 / 255.0f, 45 / 255.0f, 1);
        shapeRenderer.rect(0, middlePointY + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(147 / 255.0f, 80 / 255.0f, 27 / 255.0f, 1);
        shapeRenderer.rect(0, middlePointY + 77, 136, 52);

        // End ShapeRenderer
        shapeRenderer.end();

        // Background
        batcher.begin();
        batcher.disableBlending();
        batcher.draw(AssetLoader.bg, 0, context.middlePointY() + 23, 136, 43);
        batcher.end();
    }

}
