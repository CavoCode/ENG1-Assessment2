package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.interactive.WorldCreator;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.tests.GdxTestRunner;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class GameScreenTest {

	private static GameScreen mockedGameScreen;
	private static PirateGame mockedGame;
	
	@Before
	public void init() {
		mockedGame = MockitoWorldGen.mockGame();
		mockedGameScreen = MockitoWorldGen.mockGameScreen();
	}

	/*
	@Test(expected = Test.None.class)
	public void testInstantiation() {
		new WorldCreator(mockedGameScreen);
	}*/
	
	@Test
	public void testConstruction() {
		GameScreen screen = new GameScreen(mockedGame, true);
	}
}