package com.mygdx.pirategame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.utils.TimeUtils;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.main.PirateGame;

//-------Team-17--------
/**
 * Fire
 * Creates an object for each fire
 * Extends the entity class to define fire as an entity
 *
 *@author Zac Spooner
 *@version 1.0
 */
public class Fire extends Entity {
    private boolean setToDestroyed;
    private boolean destroyed;
    //private Sound firePickup;

    private long timeCreated = TimeUtils.millis();
    
 	private Animation<TextureRegion> fireAnimation; // Must declare frame type (TextureRegion)

 	// A variable for tracking elapsed time for the animation
 	private float stateTime;

    /**
     * Instantiates a new Fire.
     *
     * @param screen the screen its going onto
     * @param x      the x value to be placed at
     * @param y      the y value to be placed at
     */
    public Fire(GameScreen screen, float x, float y) {
        super(screen, x, y);
        //Set fire image
        makeAnimation();
        //Set the position and size of the fire
        setBounds(0,0,100 / PirateGame.PPM, 100 / PirateGame.PPM);
        //Set the texture
        //setRegion(fire);
        //Sprite a;
        //a.
        setRegion(fireAnimation.getKeyFrame(0));
        //Sets origin of the fire
        setOrigin(24 / PirateGame.PPM,24 / PirateGame.PPM);
        //firePickup = Gdx.audio.newSound(Gdx.files.internal("sounds/fire-pickup.mp3"));
    }

    /**
     * Updates the fires state. If needed, deletes the fire if picked up.
     */
    public void update() {
    	if (TimeUtils.timeSinceMillis(timeCreated) > 5000) {
    		setToDestroyed = true;
    	}
        //If fire is set to destroy and isnt, destroy it
        if(setToDestroyed && !destroyed) {
            world.destroyBody(b2body);
            destroyed = true;
        }
        //Update position of fire
        else if(!destroyed) {
        	stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        	setRegion(fireAnimation.getKeyFrame(stateTime, true));
            setPosition(b2body.getPosition().x - getWidth() / 2f, b2body.getPosition().y - getHeight() / 2f);
        }
    }

    /**
     * Defines all the parts of the fires physical model. Sets it up for collisons
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
        fdef.filter.categoryBits = PirateGame.FIRE_BIT;
        // determining what this BIT can collide with
        fdef.filter.maskBits = PirateGame.DEFAULT_BIT | PirateGame.ENEMY_BIT;
        fdef.shape = shape;
        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }

    /**
     * What happens when an entity collides with the fire. The only entity that is able to do so is the player ship
     */
    @Override
    public void entityContact() {
        //Set to destroy
        //setToDestroyed = true;
        Gdx.app.log("fire", "collision");
    }
    
    private void makeAnimation() {
		// Initialize the Animation with the frame interval and array of frames   	
    	TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("fireAtlas.atlas"));
    	fireAnimation = new Animation<TextureRegion>(0.05f, atlas.findRegions("fire"), PlayMode.LOOP);
		stateTime = 0f;
	}

    /**
     * Draws the fire using batch
     *
     * @param batch The batch of the program
     */
    public void draw(Batch batch) {
        if(!destroyed) {
            super.draw(batch);
        }
    }
}
//----------------------
