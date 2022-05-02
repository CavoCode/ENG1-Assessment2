package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.interactive.WorldContactListener;
import com.mygdx.pirategame.interactive.WorldCreator;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.entities.Coin;
import com.mygdx.pirategame.entities.College;
import com.mygdx.pirategame.entities.CollegeFire;
import com.mygdx.pirategame.entities.EnemyShip;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.tests.GdxTestRunner;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

@RunWith(GdxTestRunner.class)
public class PlayerTest {

	private static GameScreen mockedGameScreen;

    /**
     * Setup the test environment
     */
    @BeforeClass
    public static void init() {
        // Use Mockito to mock the OpenGL methods since we are running headlessly
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;

        // note all mocking cannot appear in a @Test annotated method
        // or the mocking will not work, all mocking must occur in @BeforeClass
        // at least from my testing it does not even work in a @Before method
        //MockitoWorldGen.mockHudStatic();

        mockedGameScreen = MockitoWorldGen.mockGameScreenWithPlayer();
        MockitoWorldGen.mockHudStatic();
    }
    
    /**
     * Tests the creation of the object, using arbitrary coordinates
     */
    @Test()
    public void playerMoveRight() {
    	GameScreen screen = mockedGameScreen;
        Player player = new Player(screen);
        float oldX = player.getX();
        player.applyImpuse(1, 0);
        player.update(0.1f);
        float newX = player.getX();
        assertTrue("Can player move right?",newX > oldX);
    }
    
    @Test()
    public void playerStop() {
    	GameScreen screen = mockedGameScreen;
        Player player = new Player(screen);
        player.applyImpuse(1, 0);
        float oldx = player.b2body.getLinearVelocity().x;
        for (int x = 0; x < 100; x++) {
        	player.applyImpuse(0, 0);
        }
        float newx = player.b2body.getLinearVelocity().x;
        assertTrue("Can player stop?",newx == 0);
    }
    
    @Test()
    public void playerFire() {
    	GameScreen screen = mockedGameScreen;
        Player player = new Player(screen);
        player.fire();
        float oldx = player.getCannonBalls().first().getX();
        player.update(0.5f);
        float newx = player.getCannonBalls().first().getX();
        assertTrue("Can player fire?",newx < oldx);
    }
    
    /*
    @Test()
    public void playerHitByCollege() {
    	//GameScreen screen = mockedGameScreen;
    	PirateGame pirateGame = new PirateGame();
    	GameScreen screen = new GameScreen(pirateGame, true);
    	//Player player = new Player(screen);
    	//World world = new World(new Vector2(0,0), true);
    	//new WorldCreator(screen);
    	//world.setContactListener(new WorldContactListener());
    	CollegeFire collegeFire = new CollegeFire(screen, 0, 0);
    	//world.step(1 / 60f, 6, 2);
    	assertTrue(Hud.getHealth() == 100);
    }
    */
    
    
}