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
//stuff 'that' needs for this;
//- Toggle on/off functionality
//- Location on map

/**
 * Submerged
 * Class to hold initialised lists of submerged items
 *
 *@author Joshua Saunders
 *@version 1.0
 */
public class Submerged {
    public  ArrayList<Object> sunkenItems = new ArrayList<>();
    public  ArrayList<Object> floatingItems = new ArrayList<>();
    //object is able to be (debris, powerups, ...)


    /**
     * Initialises all of the submerged items and puts them into lists
     * The submerged items are at pre-set points that were decided before the game opens
     */
    public Submerged(){
        //A list of every item being initialised into specific coordinates and put into the
        //sunkenItems list

    }


    /**
     * Takes the item, activates it and moves it from the sunkenList to the floatingList
     * @param sunkenItem a Debris or a powerup or other item
     */
    public void Rise(Object sunkenItem){
        if (sunkenItems.contains(sunkenItem)){
            floatingItems.add(sunkenItem);
            sunkenItems.remove(sunkenItem);
        }
        //activate sunkenItem
    }


    /**
     * Takes the item, de-activates it and moves it from the floatingList to the sunkenList
     * @param floatingItem a Debris or powerup or other item
     */
    public void Sink(Object floatingItem){
        if (floatingItems.contains(floatingItem)){
            sunkenItems.add(floatingItem);
            floatingItems.remove(floatingItem);
        }
        //deactivate sunken item
    }
}
