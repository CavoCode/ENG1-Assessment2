package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.interactive.WorldCreator;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.tests.GdxTestRunner;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(GdxTestRunner.class)
public class GameScreenTest {

	private static GameScreen mockedGameScreen;
	private static PirateGame mockedGame;
	
	@Before
	public void init() {
		mockedGame = MockitoWorldGen.mockGame();
		mockedGameScreen = MockitoWorldGen.mockGameScreen();
        MockitoWorldGen.mockHudStatic();
	}
	
	@Test
	public void testConstruction() {
		GameScreen screen = new GameScreen(mockedGame, true);
	}
	
	@Test
	public void gameOverCheck() {
		GameScreen screen = new GameScreen(mockedGame, true);
		Hud.changeHealth(-100);
		screen.gameOverCheck();
		assertTrue(screen.game.getScreen() == null);
	}
	
	//Can't simulate weather functionality through hud so just calling method
	@Test
	public void weatherCheck() {
		GameScreen screen = new GameScreen(mockedGame, true);
		//ensure it takes value rather than pointer
		float oldAccel = 0;
		oldAccel += Player.getAcceleration();
		
		GameScreen.weather(true);
		float newAccel = Player.getAcceleration();
		assertTrue(newAccel < oldAccel);
		
		GameScreen.weather(false);
		newAccel = Player.getAcceleration();
		//uses threshold comparison as its manipulating fp numbers
		assertTrue(Math.abs(oldAccel - newAccel) < 0.0001);
	}
}