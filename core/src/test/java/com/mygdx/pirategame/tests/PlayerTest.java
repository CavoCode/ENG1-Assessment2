package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.CollegeFire;
import com.mygdx.pirategame.entities.Fire;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class PlayerTest {

	private static GameScreen mockScreen;
	private static PirateGame mockGame;

    @BeforeClass
    public static void init() {
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockGame = MockitoWorldGen.mockGame();
        MockitoWorldGen.mockHud();
    }
    
    //PLAYER_TEST_INSTANTIATION
    @Test(expected = Test.None.class)
    public void testInstantiation() {
        new Player(mockScreen);
    }

    //PLAYER_TEST_MOVEMENT
    @Test()
    public void playerMovement() {
    	GameScreen screen = mockScreen;
        Player player = new Player(screen);
        float oldX = player.getX();
        player.applyImpuse(1, 0);
        player.update(0.1f);
        float newX = player.getX();
        assertTrue(newX > oldX);
    }
    
    //PLAYER_TEST_STOP_MOVEMENT
    @Test()
    public void playerStop() {
    	GameScreen screen = mockScreen;
        Player player = new Player(screen);
        player.applyImpuse(1, 0);
        float oldx = player.b2body.getLinearVelocity().x;
        for (int x = 0; x < 100; x++) {
        	player.applyImpuse(0, 0);
        }
        float newx = player.b2body.getLinearVelocity().x;
        assertTrue(newx == 0);
    }
    
    //PLAYER_TEST_FIRE
    @Test()
    public void playerFire() {
    	GameScreen screen = mockScreen;
        Player player = new Player(screen);
        player.fire();
        float oldx = player.getCannonBalls().first().getX();
        player.update(0.5f);
        float newx = player.getCannonBalls().first().getX();
        assertTrue(newx < oldx);
    }
    
    //PLAYER_TEST_DAMAGED
    @Test()
    public void playerDamaged() {
    	GameScreen screen = new GameScreen(mockGame, true);
    	CollegeFire collegeFire = new CollegeFire(screen, screen.getPlayerPos().x, screen.getPlayerPos().y);
    	screen.update(0.1f);
    	assertTrue(Hud.getHealth() < 100);
    }
    
    
    
}