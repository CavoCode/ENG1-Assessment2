package com.mygdx.pirategame.testing;

import com.badlogic.gdx.Gdx;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(GdxTestRunner.class)
public class AssetTesting {
	
	/*
	 * TEMPLATE
	@Test
    public void assetNameExists() {
        assertTrue("does containingFolder/assetName.png asset exist", Gdx.files
                .internal("cannonBall.png").exists());
    }
	**/

	//MAIN ASSET FOLDER
    @Test
    public void cannonBallExists() {
        assertTrue("does cannonBall.png asset exist", Gdx.files
                .internal("cannonBall.png").exists());
    }
    
    @Test
    public void coinExists() {
        assertTrue("does coin.png asset exist", Gdx.files
                .internal("coin.png").exists());
    }
    
    @Test
    public void WExists() {
        assertTrue("does W.png asset exist", Gdx.files
                .internal("W.png").exists());
    }
    
    
    //HUD ASSETS
    @Test
    public void HealthBarExists() {
        assertTrue("This test will only pass when the hp.png asset exists.", Gdx.files
                .internal("hud/hp.png").exists());
    }
    
    @Test
    public void hpExists() {
        assertTrue("This test will only pass when the HealthBar.png asset exists.", Gdx.files
                .internal("hud/HealthBar.png").exists());
    }
    
}