package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.pirategame.entities.Fire;
import com.mygdx.pirategame.entities.Fire;
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
public class FireTest {

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
    }
    
    /**
     * Tests the creation of the object, using arbitrary coordinates
     */
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
    
    
}