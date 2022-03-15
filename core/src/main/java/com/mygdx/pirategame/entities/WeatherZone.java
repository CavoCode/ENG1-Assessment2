package com.mygdx.pirategame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;

import java.util.ArrayList;
import java.util.Random;


/**
 * WeatherZone
 * Class to generate areas of weather
 * 
 *
 *@author Joshua Saunders
 *@version 1.0
 */
public class WeatherZone extends Enemy{
    /**
     * Variables from Constructor Enemy
     * protected World world;
     * protected GameScreen screen;
     * public Body b2body;
     * public boolean setToDestroy;
     * public boolean destroyed;
     * public int health; --Now being interpreted as a timer
     * public int damage;
     * public HealthBar bar;
    */
    
    //: need new class Submerged which is a singular obstacle/powerup that can be toggled on/off
    //public ArrayList<Submerged> floating = new ArrayList<>();
    public Texture weatherTexture;

    public WeatherZone (GameScreen screen, String weatherID, float x, float y, String cloud) {
        super(screen, x, y);
        this.screen = screen;
        weatherTexture = new Texture(cloud); //fix later
        //Set the position and size of the college
        setBounds(0,0,64 / PirateGame.PPM, 110 / PirateGame.PPM);
        setRegion(weatherTexture);
        setOrigin(32 / PirateGame.PPM,55 / PirateGame.PPM);
        damage = 10; //?
        int ranX = 0; //?
        int ranY = 0; //?

        //: Checks to see if any submerged rubble or powerups are in the area
        //if so, will put them in the list 'floating' and will toggle them on
    }


    @Override
    public void onContact() {

    }


    public void update(float dt) {

    }


    @Override
    protected void defineEnemy() {
    
    }
}
