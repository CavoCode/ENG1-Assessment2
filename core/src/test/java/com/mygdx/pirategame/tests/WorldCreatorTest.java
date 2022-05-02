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
public class WorldCreatorTest {

	private static GameScreen mockedGameScreen;
	
	@Before
	public void init() {
		mockedGameScreen = MockitoWorldGen.mockGameScreen();
	}

	@Test(expected = Test.None.class)
	public void testInstantiation() {
		new WorldCreator(mockedGameScreen);
	}
}