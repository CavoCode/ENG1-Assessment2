package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.Coin;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class CoinTest {

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
        //Alternatively could have mocked whole game and placed coin on player to test
        assertTrue(Hud.getCoins() == 1);
    }
    
    @Test()
    public void coinContactWorksProof() {
    	Hud.setCoins(0);
    	GameScreen screen = new GameScreen(mockGame, true);
    	Coin coin = new Coin(screen, screen.getPlayerPos().x, screen.getPlayerPos().y, false);
    	screen.update(0.1f);
        assertTrue(Hud.getCoins() == 1);
    }
}