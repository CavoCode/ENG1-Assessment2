package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class GameScreenTest {

	private static PirateGame mockGame;
	
	@Before
	public void init() {
		mockGame = MockitoWorldGen.mockGame();
        MockitoWorldGen.mockHud();
	}
	
	@Test
	public void testConstruction() {
		GameScreen screen = new GameScreen(mockGame, true);
	}
	
	@Test
	public void gameOverCheck() {
		GameScreen screen = new GameScreen(mockGame, true);
		Hud.changeHealth(-100);
		screen.gameOverCheck();
		assertTrue(screen.game.getScreen() == null);
	}
	
	//Can't simulate weather functionality through hud so just calling method
	@Test
	public void weatherCheck() {
		GameScreen screen = new GameScreen(mockGame, true);
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