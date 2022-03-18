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
    
    public Texture weatherTexture;


    /**
     * 
     * 
     * @param screen Visual Data
     * @param x Weather position on x-axis
     * @param y Weather position on y-axis
     * @param cloud Weather sprite (image name)
     */
    public WeatherZone (GameScreen screen, float x, float y, String cloud) {
        super(screen, x, y);
        this.screen = screen;
        weatherTexture = new Texture(cloud);

        //Set the position and size of the Weather area
        setBounds(0,0,64 / PirateGame.PPM, 110 / PirateGame.PPM);
        setRegion(weatherTexture);
        setOrigin(32 / PirateGame.PPM,55 / PirateGame.PPM);
        damage = 10; //?

        //: Checks to see if any submerged rubble or powerups are in the area.
        //if so, will put them in the list 'floating' and will toggle them on
    }


    //should theoretically lower the max speed of the ships in contact with it
    @Override
    public void onContact() {
        //need to figure out
    }


    public void update(float dt) {
        //need to figure out
    }


    @Override
    protected void defineEnemy() {
        //need to figure out
    }
}
