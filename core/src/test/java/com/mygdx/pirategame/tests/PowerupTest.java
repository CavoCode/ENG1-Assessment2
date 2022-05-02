package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.entities.Powerup;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.tests.GdxTestRunner;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(GdxTestRunner.class)
public class PowerupTest {

	private static GameScreen mockScreen;

    /**
     * Setup the test environment
     */
    @BeforeClass
    public static void init() {
        // Use Mockito to mock the OpenGL methods to 
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
        mockScreen = MockitoWorldGen.mockGameScreenWithPlayer();
        MockitoWorldGen.mockHudStatic();
    }
    
    /**
     * Tests the creation of the object, using arbitrary coordinates
     */
    @Test(expected = Test.None.class)
    public void testInstantiation() {
        new Powerup(mockScreen, 10, 10, false);
    }
    
    @Test()
    public void isDestoryed() {
    	GameScreen screen = mockScreen;
    	Powerup powerup = new Powerup(screen, 10, 10, false);
        powerup.entityContact();
        powerup.update();
        assertTrue(powerup.isDestroyed());
    }
    
    @Test()
    public void powerupStops() {
    	GameScreen screen = mockScreen;
    	Powerup powerup = new Powerup(screen, 10, 10, false);
        powerup.entityContact();
        GameScreen.setPowerupActivatedTime(0);
        powerup.update();
        String powerupType = GameScreen.getPowerupType();
        assertTrue(powerupType == "");
    }
    
    @Test()
    public void powerupChosen() {
    	boolean auto = false;
    	boolean astral = false;
    	boolean oil = false;
    	boolean rubber = false;
    	boolean soup = false;
    	GameScreen screen = mockScreen;
    	for (int i = 0; i < 50; i++) {
    		Powerup powerup = new Powerup(screen, 10, 10, false);
            powerup.entityContact();
            String powerupType = GameScreen.getPowerupType();
            if (powerupType == "Auto Reload") {
            	auto = true;
            }
            else if (powerupType == "Astral Body") {
            	astral = true;
            }
            else if (powerupType == "Oil Spill") {
            	oil = true;
            }
            else if (powerupType == "Rubber Coating") {
            	rubber = true;
            }
            else if (powerupType == "Soup") {
            	soup = true;
            }
    	}
        boolean all = auto && astral && oil && rubber && soup;
        assertTrue(all);
    }
    
    @Test()
    public void runPowerups() {
    	boolean test = true;
    	GameScreen screen = mockScreen;
    	Player player = new Player(screen);
    	player.turnOnSoup();
    	if (!Player.soup) {
    		test = false;
    	}
    	player.turnOffSoup();
    	if (Player.soup) {
    		test = false;
    	}
    	player.turnOnRubber();
    	if (!Player.rubber) {
    		test = false;
    	}
    	player.turnOffRubber();
    	if (Player.rubber) {
    		test = false;
    	}
    	player.turnOnAstral();
    	if (!Player.astral) {
    		test = false;
    	}
    	player.turnOffAstral();
    	if (Player.astral) {
    		test = false;
    	}
    	assertTrue(test);
    }
    
    
    
}