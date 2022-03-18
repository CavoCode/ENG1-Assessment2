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

//----------------------Needs debris/powerups to be completed first-----------------------------------------

/**
 * Submerged
 * Class to hold initialised lists of submerged items
 *
 *@author Joshua Saunders
 *@version 1.0
 */
public class Submerged {
    public  ArrayList<Object> sunkenItems = new ArrayList<>(); //dont change
    public  ArrayList<Object> floatingItems = new ArrayList<>();
    //object is able to be (debris, powerups, ...)

    
    /**
     * Initialises all of the submerged items and puts them into lists
     * The submerged items are at pre-set points that were decided before the game opens
     */
    public Submerged(){
        //A list of every item being initialised into specific coordinates

    }


    /**
     * Take the item, activate it and adds it to the floating list 
     * @param sunkenItem a Debris or a powerup or other item
     */
    public void Rise(Object sunkenItem){
        floatingItems.add(sunkenItem);
        //activate sunkenItem
    }


    /**
     * Take the item, de-activate it and removes it from the floating list 
     * @param sunkenItem a Debris or powerup or other item
     */
    public void Sink(Object sunkenItem){
        if (floatingItems.contains(sunkenItem)){
            floatingItems.remove(sunkenItem);
        }
        //deactivate sunken item
    }
}
