package ru.divizdev.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.divizdev.CBGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Zombie Bird";
		config.width = 480;
		config.height = 320;
		new LwjglApplication(new CBGame(), config);
	}
}
