package com.mygdx.pirategame.tests;

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
                .internal("containingFolder/assetName.png").exists());
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
        assertTrue("does HealthBar.png asset exist", Gdx.files
                .internal("hud/HealthBar.png").exists());
    }
    
    @Test
    public void hpExists() {
        assertTrue("does hp.png asset exist", Gdx.files
                .internal("hud/hp.png").exists());
    }
    
    @Test
    public void hudBGExists() {
        assertTrue("does hudBG.png asset exist", Gdx.files
                .internal("hud/hudBG.png").exists());
    }    
    
    //MAP ASSETS TESTS IN MapAssets.java
    
    //SHIPS&COLLEGES ASSETS
    
    @Test
    public void alcuin_flagExists() {
        assertTrue("does alcuin_flag.png asset exist", Gdx.files
                .internal("ships&colleges/alcuin_flag.png").exists());
    }
    @Test
    public void alcuin_shipExists() {
        assertTrue("does alcuin_ship.png asset exist", Gdx.files
                .internal("ships&colleges/alcuin_ship.png").exists());
    }
    @Test
    public void anne_lister_flagExists() {
        assertTrue("does anne_lister_flag.png asset exist", Gdx.files
                .internal("ships&colleges/anne_lister_flag.png").exists());
    }
    @Test
    public void anne_lister_shipExists() {
        assertTrue("does anne_lister_ship.png asset exist", Gdx.files
                .internal("ships&colleges/anne_lister_ship.png").exists());
    }
    @Test
    public void constantine_shipExists() {
        assertTrue("does constantine_ship.png asset exist", Gdx.files
                .internal("ships&colleges/constantine_flag.png").exists());
    }
    @Test
    public void constantine_flagExists() {
        assertTrue("does constantine_flag.png asset exist", Gdx.files
                .internal("ships&colleges/constantine_flag.png").exists());
    }
    @Test
    public void derwent_flagExists() {
        assertTrue("does derwent_flag.png asset exist", Gdx.files
                .internal("ships&colleges/derwent_flag.png").exists());
    }
    @Test
    public void derwent_shipExists() {
        assertTrue("does derwent_ship.png asset exist", Gdx.files
                .internal("ships&colleges/derwent_ship.png").exists());
    }
    @Test
    public void enemyShip1Exists() {
        assertTrue("does enemyShip1.png asset exist", Gdx.files
                .internal("ships&colleges/enemyShip1.png").exists());
    }
    @Test
    public void goodricke_flagExists() {
        assertTrue("does goodricke_flag.png asset exist", Gdx.files
                .internal("ships&colleges/goodricke_flag.png").exists());
    }
    @Test
    public void goodricke_shipExists() {
        assertTrue("does goodricke_ship.png asset exist", Gdx.files
                .internal("ships&colleges/goodricke_ship.png").exists());
    }
    @Test
    public void halifax_flagExists() {
        assertTrue("does halifax_flag.png asset exist", Gdx.files
                .internal("ships&colleges/halifax_flag.png").exists());
    }
    @Test
    public void james_flagExists() {
        assertTrue("does james_flag.png asset exist", Gdx.files
                .internal("ships&colleges/james_flag.png").exists());
    }
    @Test
    public void langwith_flagExists() {
        assertTrue("does langwith_flag.png asset exist", Gdx.files
                .internal("ships&colleges/langwith_flag.png").exists());
    }
    @Test
    public void player_shipExists() {
        assertTrue("does player_ship.png asset exist", Gdx.files
                .internal("ships&colleges/player_ship.png").exists());
    }
    @Test
    public void ship1Exists() {
        assertTrue("does ship1.png asset exist", Gdx.files
                .internal("ships&colleges/ship1.png").exists());
    }
    @Test
    public void unaligned_shipExists() {
        assertTrue("does unaligned_ship.png asset exist", Gdx.files
                .internal("ships&colleges/unaligned_ship.png").exists());
    }
    @Test
    public void vanbrugh_flagExists() {
        assertTrue("does vanbrugh_flag.png asset exist", Gdx.files
                .internal("ships&colleges/vanbrugh_flag.png").exists());
    }
    
    //SKIN ASSETS
    
    @Test
    public void defaultfntExists() {
        assertTrue("does default.fnt asset exist", Gdx.files
                .internal("skin/default.fnt").exists());
    }
    
    @Test
    public void uiskinatlasExists() {
        assertTrue("does uiskin.atlas asset exist", Gdx.files
                .internal("skin/uiskin.atlas").exists());
    }
    
    @Test
    public void uiskinjsonExists() {
        assertTrue("does uiskin.json asset exist", Gdx.files
                .internal("skin/uiskin.json").exists());
    }
    
    @Test
    public void uiskinpngExists() {
        assertTrue("does uiskin.png asset exist", Gdx.files
                .internal("skin/uiskin.png").exists());
    }
    
    //SOUNDS ASSETS
    
    @Test
    public void coinPickupExists() {
        assertTrue("does coinPickup.mp3 asset exist", Gdx.files
                .internal("sounds/coinPickup.mp3").exists());
    }
    
    @Test
    public void explosionExists() {
        assertTrue("does explosion.wav asset exist", Gdx.files
                .internal("sounds/explosion.wav").exists());
    }
    
    @Test
    public void pirateMusic() {
        assertTrue("does pirateMusic.mp3 asset exist", Gdx.files
                .internal("sounds/pirateMusic.mp3").exists());
    }
    
    @Test
    public void shipExplosionExists() {
        assertTrue("does shipExplosion.wav asset exist", Gdx.files
                .internal("sounds/shipExplosion.wav3").exists());
    }
    
    @Test
    public void shipHit() {
        assertTrue("does shipHit.wav asset exist", Gdx.files
                .internal("sounds/shipHit.wav").exists());
    }
    
    @Test
    public void woodBumpExists() {
        assertTrue("does woodBump.mp3 asset exist", Gdx.files
                .internal("sounds/woodBump.mp3").exists());
    }
}