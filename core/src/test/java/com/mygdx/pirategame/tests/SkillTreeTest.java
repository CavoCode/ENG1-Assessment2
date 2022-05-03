package com.mygdx.pirategame.tests;

import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.MockitoWorldGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(GdxTestRunner.class)
public class SkillTreeTest {

	private static GameScreen mockScreen;
	private static PirateGame mockedGame;

    @BeforeClass
    public static void init() {
        mockScreen = MockitoWorldGen.mockGameScreen();
        mockedGame = MockitoWorldGen.mockGame();
        MockitoWorldGen.mockHud();
    }
    
    @Test
    public void dummyTest() {
    	//this is just here so that testing doesnt fail
    }
}