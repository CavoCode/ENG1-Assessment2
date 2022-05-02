package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.entities.College;
import com.mygdx.pirategame.entities.AvailableSpawn;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class CollegeTest {

	private static GameScreen mockScreen;
	private static PirateGame mockGame;

    @BeforeClass
    public static void init() {
        MockitoWorldGen.mockHud();
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockGame = MockitoWorldGen.mockGame();
    }
    

    @Test()
    public void collegeDestoryed() {
    	GameScreen screen = mockScreen;
    	AvailableSpawn invalidSpawn = new AvailableSpawn();
    	String difficulty = "easy";
    	String flag = "ships&colleges/anne_lister_flag.png";
    	String ship = "ships&colleges/anne_lister_ship.png";
        College college = new College(screen, "Anne Lister",10, 10,
               flag, ship, 8, invalidSpawn, difficulty);
        
        college.health = 0;
        college.update(0.1f);
        college.update(0.1f);
        assertTrue(college.isDestroyed());
    }
    
    @Test()
    public void collegeDamaged() {
    	GameScreen screen = mockScreen;
    	AvailableSpawn invalidSpawn = new AvailableSpawn();
    	String difficulty = "easy";
    	String flag = "ships&colleges/anne_lister_flag.png";
    	String ship = "ships&colleges/anne_lister_ship.png";
        College college = new College(screen, "Anne Lister",10, 10,
               flag, ship, 8, invalidSpawn, difficulty);
        
        college.onContact();
        college.update(0.1f);
        assertTrue(college.health < 100);
    }
    
    @Test()
    public void collegeFire() {
    	GameScreen screen = new GameScreen(mockGame, true);
    	AvailableSpawn invalidSpawn = new AvailableSpawn();
    	String difficulty = "easy";
    	String flag = "ships&colleges/anne_lister_flag.png";
    	String ship = "ships&colleges/anne_lister_ship.png";
        College college = new College(screen, "Anne Lister",10, 10,
               flag, ship, 8, invalidSpawn, difficulty);
        
        college.fire();
        float oldx = college.getCannonBalls().first().getX();
        college.update(0.5f);
        float newx = college.getCannonBalls().first().getX();
        assertTrue("Can college fire?",newx < oldx);
    }
}