package com.mygdx.pirategame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;

/**
 * Coin
 * Creates an object for each coin
 * Extends the entity class to define coin as an entity
 *
 *@author Joe Dickinson, Josh Saunders
 *@version 2.0
 */
public class Coin extends Entity {
    private Texture coin;
    //Team17--
    private Texture none;
    private Boolean floating;
    private Boolean sunken;
    //--------
    private boolean setToDestroyed;
    private boolean destroyed;
    private Sound coinPickup;

    /**
     * Instantiates a new Coin.
     *
     * @param screen the screen its going onto
     * @param x      the x value to be placed at
     * @param y      the y value to be placed at
     * @param sunken whether it is a submerged coin or not (true=it is)
     */
    public Coin(GameScreen screen, float x, float y, Boolean sunken) {
        super(screen, x, y);

        //Team 17--
        this.floating = true;
        this.sunken = sunken;
        //---------

        //Set coin image
        coin = new Texture("coin.png");
        //Team17 - Set blank image
        none = new Texture("w.png"); //Make this null.png image, but null.png being a transparent image
        //Set the position and size of the coin
        setBounds(0,0,48 / PirateGame.PPM, 48 / PirateGame.PPM);
        //Set the texture
        setRegion(coin);
        //Sets origin of the coin
        setOrigin(24 / PirateGame.PPM,24 / PirateGame.PPM);
        coinPickup = Gdx.audio.newSound(Gdx.files.internal("sounds/coin-pickup.mp3"));
    }

    /**
     * Updates the coins state. If needed, deletes the coin if picked up.
     */
    public void update() {
        //If coin is set to destroy and isnt, destroy it
        if(setToDestroyed && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
        }
        //Update position of coin
        else if(!destroyed) {
            setPosition(b2body.getPosition().x - getWidth() / 2f, b2body.getPosition().y - getHeight() / 2f);
        }
    }

    /**
     * Defines all the parts of the coins physical model. Sets it up for collisons
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
        fdef.filter.categoryBits = PirateGame.COIN_BIT;
        // determining what this BIT can collide with
        fdef.filter.maskBits = PirateGame.DEFAULT_BIT | PirateGame.PLAYER_BIT | PirateGame.ENEMY_BIT;
        fdef.shape = shape;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }

    /**
     * What happens when an entity collides with the coin. The only entity that is able to do so is the player ship
     */
    @Override
    public void entityContact() {
        //Team 17 - Checks if coin is submerged
        if (floating == true){
            //Add a coin
            Hud.changeCoins(1);
            //Set to destroy
            setToDestroyed = true;
            Gdx.app.log("coin", "collision");
            //Play pickup sound
            if (screen.game.getPreferences().isEffectsEnabled()) {
                coinPickup.play(screen.game.getPreferences().getEffectsVolume());
            }
        }

    }

    /**
     * Draws the coin using batch
     *
     * @param batch The batch of the program
     */
    public void draw(Batch batch) {
        if(!destroyed) {
            super.draw(batch);
        }
    }

    /**
     * Team 17
     * Defines whether the coin is there or invisible / un-interactable
     * @param bool true = coin is there, false = coin is underwater (not there)
     */
    public void setVisible(Boolean bool){
        //Checks if this coin is able to sink
        if (sunken){
            floating = bool;
            if (!bool){
                //changes texture to a transparent texture
                setRegion(none);
            }
            else{
                //changes texture to a coin texture
                setRegion(coin);
            }
        }
    }
}
