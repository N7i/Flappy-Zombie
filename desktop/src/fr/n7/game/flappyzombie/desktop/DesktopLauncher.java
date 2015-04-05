package fr.n7.game.flappyzombie.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.n7.game.flappyzombie.FlappyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.title = "Flappy Zombie";
        config.width = 272;
        config.height = 480;

		new LwjglApplication(new FlappyGame(), config);
	}
}
