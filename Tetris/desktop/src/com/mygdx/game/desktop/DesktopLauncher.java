package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Main;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.pauseS;
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=500;
		config.width=600;
		new LwjglApplication(new Main(), config);
	}

}
