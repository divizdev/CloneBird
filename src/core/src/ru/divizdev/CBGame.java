package ru.divizdev;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import ru.divizdev.Helpers.AssetLoader;
import ru.divizdev.screen.SplashScreen;

public class CBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("CBGame", "create");
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose(){
		super.dispose();
		AssetLoader.dispose();
	}
}
