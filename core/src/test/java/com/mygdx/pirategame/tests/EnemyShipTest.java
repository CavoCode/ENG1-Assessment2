package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.interactive.WorldContactListener;
import com.mygdx.pirategame.interactive.WorldCreator;
import com.mygdx.pirategame.entities.EnemyShip;
import com.mygdx.pirategame.entities.AvailableSpawn;
import com.mygdx.pirategame.entities.Coin;
import com.mygdx.pirategame.entities.EnemyShip;
import com.mygdx.pirategame.entities.CollegeFire;
import com.mygdx.pirategame.entities.Player;
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
public class EnemyShipTest {

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
        MockitoWorldGen.mockHudStatic();

        mockedGameScreen = MockitoWorldGen.mockGameScreenWithPlayer();
    }
    
    /* might test these if have time
    @Test()
    public void enemyShipDestroyed() {
    	GameScreen screen = mockedGameScreen;
        EnemyShip enemyShip = new EnemyShip(screen);
        enemyShip.applyImpuse(1, 0);
        float oldx = enemyShip.b2body.getLinearVelocity().x;
        for (int x = 0; x < 100; x++) {
        	enemyShip.applyImpuse(0, 0);
        }
        float newx = enemyShip.b2body.getLinearVelocity().x;
        assertTrue("Can enemyShip stop?",newx == 0);
    }*/
    
    @Test()
    public void enemyShipFire() {
    	GameScreen screen = mockedGameScreen;
    	String difficulty = "easy";
        EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
        		"ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
        enemyShip.fire();
        float oldx = enemyShip.getCannonBalls().first().getX();
        enemyShip.update(0.5f);
        float newx = enemyShip.getCannonBalls().first().getX();
        assertTrue("Can enemyShip fire?",newx < oldx);
    }
    
    @Test()
    public void enemyShipFollow() {
    	GameScreen screen = mockedGameScreen;
    	Player player = new Player(screen);
    	String difficulty = "hard";
    	Vector2 playerPos = screen.getPlayerPos();
        EnemyShip enemyShip = new EnemyShip(screen, playerPos.x + 3, playerPos.y + 3,
                "ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
       
        enemyShip.update(0.5f);
        assertTrue(enemyShip.getCannonBalls().size > 0);
    }
    
    @Test()
    public void enemyShipMove() {
    	boolean test = true;
    	GameScreen screen = mockedGameScreen;
    	String difficulty = "easy";
    	String ship = "ships&colleges/anne_lister_ship.png";
    	String college = "Unaligned";
    	for (int x = 0; x < 4; x++) {
    		switch(x) {
    		case 1:
    			college = "Anne Lister";
    			break;
    		case 2:
    			college = "Goodricke";
    			break;
    		case 3:
    			college = "Constantine";
    			break;
    		}
    		
    		EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
                    ship, college,  difficulty);
            float oldvel = enemyShip.b2body.getLinearVelocity().x;
            enemyShip.update(5f);
            enemyShip.update(5f);
            enemyShip.update(5f);
            float newvel = enemyShip.b2body.getLinearVelocity().x;
            if (oldvel == newvel) {
            	test = false;
            }
    	}
        assertTrue(test);
    }
    
    @Test()
    public void enemyShipHitByPlayer() {
    	GameScreen screen = mockedGameScreen;
    	String difficulty = "easy";
    	String ship = "ships&colleges/anne_lister_ship.png";
    	String college = "Anne Lister";
    	EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
                ship, college,  difficulty);
    	enemyShip.onContact();
    	
    	assertTrue(enemyShip.health < 100);
    }
    
    
}