package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.Coin;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class CoinTest {

	private static GameScreen mockScreen;

    @BeforeClass
    public static void init() {
        mockScreen = MockitoWorldGen.mockGameScreen();
        MockitoWorldGen.mockHud();
    }
    
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
    public void coinContactWorks() {
    	Hud.setCoins(0);
    	GameScreen screen = mockScreen;
    	Coin coin = new Coin(screen, 10, 10, false);
        coin.entityContact();
        assertTrue(Hud.getCoins() == 1);
    }
    
}