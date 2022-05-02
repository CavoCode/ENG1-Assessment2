package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.entities.Powerup;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class PowerupTest {

	private static GameScreen mockScreen;
	private static PirateGame mockGame;


    @BeforeClass
    public static void init() {
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockGame = MockitoWorldGen.mockGame();
        MockitoWorldGen.mockHud();
    }
    
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
    public void keepPowerups() {
    	boolean test = true;
    	GameScreen screen = new GameScreen(mockGame, true);
    	Player player = new Player(screen);
    	GameScreen.setPowerupType("Soup");
    	screen.update(0.3f);
    	if (!Player.soup) {
    		test = false;
    	}
    	GameScreen.setPowerupType("Auto Reload");
    	screen.update(0.3f);
    	if (Player.soup) {
    		test = false;
    	}
    	GameScreen.setPowerupType("Astral Body");
    	screen.update(0.3f);
    	if (!Player.astral) {
    		test = false;
    	}
    	GameScreen.setPowerupType("Oil Spill");
    	screen.update(0.3f);
    	if (Player.astral) {
    		test = false;
    	}
    	GameScreen.setPowerupType("Rubber Coating");
    	screen.update(0.3f);
    	if (!Player.rubber) {
    		test = false;
    	}
    	GameScreen.setPowerupType("");
    	screen.update(0.3f);
    	if (Player.rubber) {
    		test = false;
    	}
    	assertTrue(test);
    }
    
    
    
}