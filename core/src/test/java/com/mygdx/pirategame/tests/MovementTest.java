package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.tests.GdxTestRunner;
import com.mygdx.pirategame.tests.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class MovementTest {

	/*
	@Test
	public void test() {
		idk how this works or how to test is will find out at some point
		PirateGame game = new PirateGame();
		GameScreen screen = new GameScreen(game);
		Player player = new Player(screen);
		//assertEquals(player.dragFactor, 1.0f);
		 
		assertEquals(1, 1);
	}
	*/
	private static GameScreen mockedGameScreen;
	
	@Before
	public void init() {
		mockedGameScreen = MockitoWorldGen.mockGameScreenWithPlayer();
	}

	@Test
	public void testInitialHealth() {
		//mockGameScreenWithPlayer
		mockedGameScreen = MockitoWorldGen.mockGameScreenWithPlayer();
		//GameScreen gameScreen = (GameScreen) MockitoWorldGen.createGameAndScreen().getScreen();
		Player player = new Player(mockedGameScreen);
		Hud hud = new Hud();
	}
}