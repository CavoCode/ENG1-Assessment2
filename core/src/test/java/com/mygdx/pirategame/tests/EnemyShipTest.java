package com.mygdx.pirategame.tests;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.pirategame.entities.AvailableSpawn;
import com.mygdx.pirategame.entities.College;
import com.mygdx.pirategame.entities.EnemyShip;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class EnemyShipTest {

	private static GameScreen mockScreen;
	private static PirateGame mockGame;

    @BeforeClass
    public static void init() {
        MockitoWorldGen.mockHud();
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockGame = MockitoWorldGen.mockGame();
    }
    
    //ENEMY_TEST_INSTANTIATION
    @Test(expected = Test.None.class)
    public void testInstantiation() {
    	GameScreen screen = mockScreen;
    	String difficulty = "easy";
        new EnemyShip(screen, 10, 10,
        		"ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
    }
    
    //ENEMY_TEST_DESTROYED
    @Test()
    public void enemyShipDestroyed() {
    	GameScreen screen = mockScreen;
    	String difficulty = "easy";
        EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
        		"ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
        
        enemyShip.health = 0;
        enemyShip.update(0.1f);
        enemyShip.update(0.1f);
        assertTrue(enemyShip.isDestroyed());
    }
    
    //ENEMY_TEST_FIRE
    @Test()
    public void enemyShipFire() {
    	GameScreen screen = new GameScreen(mockGame, true);
    	String difficulty = "easy";
        EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
        		"ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
        enemyShip.fire();
        float oldx = enemyShip.getCannonBalls().first().getX();
        enemyShip.update(0.5f);
        float newx = enemyShip.getCannonBalls().first().getX();
        assertTrue("Can enemyShip fire?",newx < oldx);
    }
    
    //ENEMY_TEST_FIRE_ON_PLAYER
    @Test()
    public void enemyShipFireOnPlayer() {
    	GameScreen screen = new GameScreen(mockGame, true);
    	//Player player = new Player(screen);
    	String difficulty = "hard";
    	Vector2 playerPos = screen.getPlayerPos();
        EnemyShip enemyShip = new EnemyShip(screen, playerPos.x + 3, playerPos.y + 3,
                "ships&colleges/anne_lister_ship.png", "Anne Lister",  difficulty);
       
        enemyShip.update(0.5f);
        assertTrue(enemyShip.getCannonBalls().size > 0);
    }
    
    //ENEMY_TEST_MOVE
    @Test()
    public void enemyShipMove() {
    	boolean test = true;
    	GameScreen screen = new GameScreen(mockGame, true);
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
            float oldvelx = enemyShip.b2body.getLinearVelocity().x;
            float oldvely = enemyShip.b2body.getLinearVelocity().y;
            enemyShip.update(5f);
            enemyShip.update(5f);
            enemyShip.update(5f);
            float newvelx = enemyShip.b2body.getLinearVelocity().x;
            float newvely = enemyShip.b2body.getLinearVelocity().y;
            if (oldvelx == newvelx && oldvely == newvely) {
            	test = false;
            }
    	}
        assertTrue(test);
    }
    
    //ENEMY_TEST_DAMAGED
    @Test()
    public void enemyShipDamaged() {
    	GameScreen screen = mockScreen;
    	String difficulty = "easy";
    	String ship = "ships&colleges/anne_lister_ship.png";
    	String college = "Anne Lister";
    	EnemyShip enemyShip = new EnemyShip(screen, 10, 10,
                ship, college,  difficulty);
    	enemyShip.onContact();
    	
    	assertTrue(enemyShip.health < 100);
    }
    
    
}