package com.mygdx.pirategame.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.TimeUtils;

import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;

/**
 * Coin
 * Creates an object for each powerup
 * Extends the entity class to define powerup as an entity
 *
 *@author Zac Spooner
 *@version 1.0
 */
public class Powerup extends Entity {
    private Texture powerup;
    private boolean setToDestroyed;
    private boolean destroyed;
    private Sound powerupPickup;
    private long powerupTimeLength = 5000;
    //For submerged
    private Texture none;
    private Boolean floating;
    private Boolean sunken;
    
    public Random random = new Random();

    /**
     * Instantiates a new powerUp.
     *
     * @param screen the screen its going onto
     * @param x      the x value to be placed at
     * @param y      the y value to be placed at
     * @param sunken whether it is submerged or not (true=it is)
     */
    public Powerup(GameScreen screen, float x, float y, Boolean sunken) {
        super(screen, x, y);
        //Set its state of floating
        this.sunken = sunken;
        this.floating = !sunken;
        //Set invisible texture
        none = new Texture("null.png");
        //Set powerup image
        powerup = new Texture("powerup3.png");
        //Set the position and size of the powerup
        setBounds(0,0,48 / PirateGame.PPM, 48 / PirateGame.PPM);
        //Set the texture
        setRegion(powerup);
        //Sets origin of the powerup
        setOrigin(24 / PirateGame.PPM,24 / PirateGame.PPM);
        powerupPickup = Gdx.audio.newSound(Gdx.files.internal("sounds/powerup-pickup.wav"));
        
    }

    /**
     * Updates the powerups state. If needed, deletes the powerup if picked up.
     */
    public void update() {
    	
    	// turns off active powerup the time has run out
        if(TimeUtils.timeSinceMillis(GameScreen.getPowerupActivatedTime()) > powerupTimeLength) {
        	turnOffPowerups();
        	GameScreen.setPowerupActivatedTime(TimeUtils.millis());
        }
    	
        //If powerup is set to destroy and isnt, destroy it
        if(setToDestroyed && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
        }
        //Update position of powerup
        else if(!destroyed) {
            setPosition(b2body.getPosition().x - getWidth() / 2f, b2body.getPosition().y - getHeight() / 2f);
        }
    }

    /**
     * Defines all the parts of the powerups physical model. Sets it up for collisons
     */
    @Override
    protected void defineEntity() {
        //sets the body definitions
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        //Sets collision boundaries
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(24 / PirateGame.PPM);
        // setting BIT identifier
        fdef.filter.categoryBits = PirateGame.POWERUP_BIT;
        // determining what this BIT can collide with
        fdef.filter.maskBits = PirateGame.DEFAULT_BIT | PirateGame.PLAYER_BIT;
        fdef.shape = shape;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }

    /**
     * What happens when an entity collides with the powerups. The only entity that is able to do so is the player ship
     */
    @Override
    public void entityContact() {
        //Checks if powerup is submerged
        if (floating == true){
            //ENTER COLLISION CODE HERE
            turnOffPowerups();
            //renew powerup active countdown which can extend life of some powerups e.g. astral body
            GameScreen.setPowerupActivatedTime(TimeUtils.millis());
            switch(random.nextInt(5)) {
            case 0:
                Hud.setPowerupType("Auto Reload");
                GameScreen.setPowerupType("Auto Reload");
                break;
            case 1:
                Hud.setPowerupType("Astral Body");
                GameScreen.setPowerupType("Astral Body");
                break;
            case 2:
                Hud.setPowerupType("Oil Spill");
                GameScreen.setPowerupType("Oil Spill");
                break;
            case 3:
                Hud.setPowerupType("Rubber Coating");
                GameScreen.setPowerupType("Rubber Coating");
                break;
            case 4:
                Hud.setPowerupType("Soup");
                GameScreen.setPowerupType("Soup");
                break;
            }
            //Set to destroy
            setToDestroyed = true;
            Gdx.app.log("powerup", "collision");
            //Play pickup sound
            if (screen.game.getPreferences().isEffectsEnabled()) {
                powerupPickup.play(screen.game.getPreferences().getEffectsVolume());
            }
        }

    }
    /**
     * Makes no powerup active
     */
    private void turnOffPowerups() {
    	Hud.setPowerupType("");
    	GameScreen.setPowerupType("");
    }

    /**
     * Draws the powerup using batch
     *
     * @param batch The batch of the program
     */
    public void draw(Batch batch) {
        if(!destroyed) {
            super.draw(batch);
        }
    }

    /**
     * Defines whether the powerup is there or invisible / un-interactable
     * @param bool true = it is there, false = it is underwater (not there)
     */
    public void setVisible(Boolean bool){
        //Checks if this powerup is able to sink
        if (sunken){
            floating = bool;
            if (!bool){
                //changes texture to a transparent texture
                setRegion(none);
            }
            else{
                //changes texture to a coin texture
                setRegion(powerup);
            }
        }
    }
}
