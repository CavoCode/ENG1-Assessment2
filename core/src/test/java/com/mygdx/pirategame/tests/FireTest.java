package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.EnemyShip;
import com.mygdx.pirategame.entities.Fire;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class FireTest {

	private static GameScreen mockScreen;
	private static PirateGame mockGame;

    @BeforeClass
    public static void init() {
    	MockitoWorldGen.mockHud();
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockGame = MockitoWorldGen.mockGame();
    }
    
    @Test(expected = Test.None.class)
    public void testInstantiation() {
        new Fire(mockScreen, 10, 10);
    }
    
    @Test()
    public void isDestoryed() {
    	GameScreen screen = mockScreen;
    	Fire fire = new Fire(screen, 10, 10);
        fire.entityContact();
        fire.timeCreated -= 5000;
        fire.update();
        assertTrue(fire.isDestroyed());
    }
    
    @Test()
    public void damagesEnemy() {
    	GameScreen screen = new GameScreen(mockGame, true);
    	String difficulty = "easy";
        EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
        		"ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
        Fire fire = new Fire(screen, 10, 10);
        screen.update(0.1f);
        assertTrue(enemyShip.health < 100);
    }
}