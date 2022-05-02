package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.pirategame.entities.Coin;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.hud.Hud;
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
public class CoinTest {

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
        new Coin(mockScreen, 10, 10, false);
    }
    
    @Test()
    public void isDestoryed() {
    	GameScreen screen = mockScreen;
    	Coin coin = new Coin(screen, 10, 10, false);
        coin.entityContact();
        coin.update();
        assertTrue(coin.isDestroyed());
    }
    
    @Test()
    public void coinStops() {
    	Hud.setCoins(0);
    	GameScreen screen = mockScreen;
    	Coin coin = new Coin(screen, 10, 10, false);
        coin.entityContact();
        assertTrue(Hud.getCoins() == 1);
    }
    
}