package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.hud.audioControls;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.GameScreen;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

@RunWith(GdxTestRunner.class)
public class MockitoWorldGen {
	
	public void testInitialHealth() {
		assertEquals(1,1);
	}

	public static void createDefaultScoreAndPoints() {
		Hud display = Mockito.mock(Hud.class);

		// Default data.
		Whitebox.setInternalState(display, "scoreLabel", new Label("0", new Label.LabelStyle(new BitmapFont(), Color.WHITE)));
		Whitebox.setInternalState(display, "coinLabel", new Label("0", new Label.LabelStyle(new BitmapFont(), Color.YELLOW)));
		Whitebox.setInternalState(display, "coinMulti", 1);

		//Hud.setScore(0);
		//Hud.setCoins(0);
	}

	public static PirateGame createGame() {
		PirateGame pirateGame = Mockito.mock(PirateGame.class);

		audioControls AudioControls = new audioControls();

		Whitebox.setInternalState(pirateGame, "options", AudioControls);
		Mockito.when(pirateGame.getPreferences()).thenReturn(AudioControls);

		return pirateGame;
	}

	public static GameScreen createScreen() {
		GameScreen screen = Mockito.mock(GameScreen.class);
		
		Mockito.when(screen.getWorld()).thenReturn(new World(new Vector2(0, 0), true));

        // mocking the map
        //TmxMapLoader mapLoader = new TmxMapLoader();
        //Mockito.when(screen.getMap()).thenReturn(mapLoader.load("map/map.tmx"));
        //Mockito.when(screen.getTileMapWidth()).thenReturn(128 * 64);
        //Mockito.when(screen.getTileMapHeight()).thenReturn(128 * 64);
        //Mockito.when(screen.getTileWidth()).thenReturn(64);
		
		/*
		Whitebox.setInternalState(screen, "world", world);
		Whitebox.setInternalState(screen, "camera", new OrthographicCamera());
		Whitebox.setInternalState(screen, "renderer", Mockito.mock(OrthogonalTiledMapRenderer.class));

		Mockito.when(screen.getWorld()).thenCallRealMethod();*/

		return screen;
	}

	public static PirateGame createGameAndScreen() {
		PirateGame pirateGame = createGame();
		GameScreen GameScreen = createScreen();

		Whitebox.setInternalState(pirateGame, "gameScreen", GameScreen);
		Mockito.when(pirateGame.getScreen()).thenReturn(GameScreen);

		Whitebox.setInternalState(GameScreen, "game", pirateGame);
		Whitebox.setInternalState(pirateGame, "batch", Mockito.mock(SpriteBatch.class));

		Whitebox.setInternalState(GameScreen, "Hud", new Hud(pirateGame.batch));
		//Mockito.when(GameScreen.getHud()).thenReturn(new Hud(pirateGame.batch));

		
		/*
		Mockito.when(GameScreen.checkGenPos(Mockito.anyInt(), Mockito.anyInt())).thenCallRealMethod();
		Mockito.when(GameScreen.generateCoins(Mockito.anyInt())).thenCallRealMethod();
		Mockito.when(GameScreen.generateShips(Mockito.anyInt())).thenCallRealMethod();
		Mockito.when(GameScreen.generateRandomLocations(Mockito.anyInt())).thenCallRealMethod();
		*/

		pirateGame.setScreen(GameScreen); // game screen.

		return pirateGame;
	}
	
	public static GameScreen mockGameScreenWithPlayer() {
        GameScreen screen = createScreen();

        Mockito.when(screen.getPlayerPos()).thenReturn(new Vector2(13*64 / PirateGame.PPM, 11*64 / PirateGame.PPM));

        return screen;
    }

	public static Player mockPlayer(GameScreen GameScreen) {
		Player player = new Player(GameScreen);

		return player;
	}
}