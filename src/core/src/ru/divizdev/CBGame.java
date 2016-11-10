package ru.divizdev;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import ru.divizdev.screen.GameScreen;

public class CBGame extends Game {

	@Override
	public void create() {
		Gdx.app.log("CBGame", "create");
		setScreen(new GameScreen());
	}
}
