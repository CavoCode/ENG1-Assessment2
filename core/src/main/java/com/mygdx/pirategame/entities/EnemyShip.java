package com.mygdx.pirategame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.mygdx.pirategame.screens.GameScreen;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;

import java.util.Random;

/**
 * Enemy Ship
 * Generates enemy ship data
 * Instantiates an enemy ship
 *
 *@author Ethan Alabaster, Sam Pearson, Edward Poulter
 *@version 1.0
 */
public class EnemyShip extends Enemy {
    private Texture enemyShip;
    public String college;
    public Random rand = new Random();
    private boolean moved = false;
    private float movingTime = 0;
    private Sound destroy;
    private Sound hit;

    /**
     * Instantiates enemy ship
     *
     * @param screen Visual data
     * @param x x coordinates of entity
     * @param y y coordinates of entity
     * @param path path of texture file
     * @param assignment College ship is assigned to
     */
    public EnemyShip(GameScreen screen, float x, float y, String path, String assignment) {
        super(screen, x, y);
        enemyShip = new Texture(path);
        //Assign college
        college = assignment;
        //Set audios
        destroy = Gdx.audio.newSound(Gdx.files.internal("sounds/ship-explosion-2.wav"));
        hit = Gdx.audio.newSound(Gdx.files.internal("sounds/ship-hit.wav"));
        //Set the position and size of the college
        setBounds(0,0,64 / PirateGame.PPM, 110 / PirateGame.PPM);
        setRegion(enemyShip);
        setOrigin(32 / PirateGame.PPM,55 / PirateGame.PPM);
        damage = 20;
    }

    /**
     * Updates the state of each object with delta time
     * Checks for ship destruction
     *
     * @param dt Delta time (elapsed time since last game tick)
     */
    public void update(float dt) {
        //If ship is set to destroy and isnt, destroy it
        if(setToDestroy && !destroyed) {
            //Play death noise
            if (screen.game.getPreferences().isEffectsEnabled()) {
                destroy.play(screen.game.getPreferences().getEffectsVolume());
            }
            world.destroyBody(b2body);
            destroyed = true;
            //Change player coins and points
            Hud.changePoints(20);
            Hud.changeCoins(10);
        }
        else if(!destroyed) {
            //Update position and angle of ship
            setPosition(b2body.getPosition().x - getWidth() / 2f, b2body.getPosition().y - getHeight() / 2f);
            float angle = (float) Math.atan2(b2body.getLinearVelocity().y, b2body.getLinearVelocity().x);
            b2body.setTransform(b2body.getWorldCenter(), angle - ((float) Math.PI) / 2.0f);
            setRotation((float) (b2body.getAngle() * 180 / Math.PI));
            //Update health bar
            bar.update();
        }
        if(health <= 0) {
            setToDestroy = true;
        }
        //Team17 Start of Change
        else {
        	//System.out.println(orgCord);
        	aiTracking(dt);
        }
   }
       //Team17 End of Change
    

    /**
     * Constructs the ship batch
     *
     * @param batch The batch of visual data of the ship
     */
    public void draw(Batch batch) {
        if(!destroyed) {
            super.draw(batch);
            //Render health bar
            bar.render(batch);
        }
    }

    /**
     * Defines the ship as an enemy
     * Sets data to act as an enemy
     */
    @Override
    protected void defineEnemy() {
        //sets the body definitions
        BodyDef bdef = new BodyDef();
        bdef.position.set(getX(), getY());
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        //Sets collision boundaries
        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(55 / PirateGame.PPM);
        // setting BIT identifier
        fdef.filter.categoryBits = PirateGame.ENEMY_BIT;
        // determining what this BIT can collide with
        fdef.filter.maskBits = PirateGame.DEFAULT_BIT | PirateGame.PLAYER_BIT | PirateGame.ENEMY_BIT | PirateGame.CANNON_BIT;
        fdef.shape = shape;
        fdef.restitution = 0.7f;
        b2body.createFixture(fdef).setUserData(this);
        
    }

    /**
     * Checks contact
     * Changes health in accordance with contact and damage
     */
    @Override
    public void onContact() {
        Gdx.app.log("enemy", "collision");
        //Play collision sound
        if (screen.game.getPreferences().isEffectsEnabled()) {
            hit.play(screen.game.getPreferences().getEffectsVolume());
        }
        //Deal with the damage
        health -= damage;
        bar.changeHealth(damage);
        Hud.changePoints(5);
    }

    //Team17 Start of Change - Ai idle movement
    
    private void aiTracking(float dt) {
    	movingTime += dt;
    	if(college != "Alcuin") {
	    	Vector2 target = screen.getPlayerPos();
	        if ((target.x >= b2body.getPosition().x - 3 && target.x <= b2body.getPosition().x + 3) && (target.y >= b2body.getPosition().y - 3 && target.y <= b2body.getPosition().y + 3)) {
	        	moveToCord(target, 1.5f);
	            moved = true;
	        }
	        else {
	        	if(college == "Unaligned") {
	        		if(movingTime >= 3.5f + Math.random()) {
		        		int ranX = 0;
		        		int ranY = 0;
		        		boolean validLoc = false;
		        		while (!validLoc) {
		                    //Get random x and y coords
		        			ranX = rand.nextInt(AvailableSpawn.xCap - AvailableSpawn.xBase) + AvailableSpawn.xBase;
		        			ranY = rand.nextInt(AvailableSpawn.yCap - AvailableSpawn.yBase) + AvailableSpawn.yBase;
		                    validLoc = screen.checkGenPos(ranX, ranY);
		        		} 
		                Vector2 randomCord = new Vector2(ranX,ranY);
		        		moveToCord(randomCord, 0.5f);
		        		movingTime = 0.0f;
	        		}
	        		
	        	}
	        	else if (college == "Goodricke") {
	        		if(movingTime >= 3.5f + Math.random()) {
		        		int ranX = 0;
		        		int ranY = 0;
		        		boolean validLoc = false;
		        		while (!validLoc) {
		                    //Get random x and y coords
		        			ranX = rand.nextInt(2000) - 1000;
		                    ranY = rand.nextInt(2000) - 1000;
		                    ranX = (int)Math.floor((1760 / PirateGame.PPM) + (ranX / PirateGame.PPM));
		                    ranY = (int)Math.floor((6767 / PirateGame.PPM) + (ranY / PirateGame.PPM));
		                    validLoc = screen.checkGenPos(ranX, ranY);
		        		} 
		                Vector2 randomCord = new Vector2(ranX,ranY);
		        		moveToCord(randomCord, 0.5f);
		        		movingTime = 0.0f;
	        		}
	        	}
	        }
        }
	}
    
    private void moveToCord(Vector2 cordTemp, float speed) { 
    	cordTemp.sub(b2body.getPosition());
    	cordTemp.nor();
        b2body.setLinearVelocity(cordTemp.scl(speed));
    }
    
    //Team17 End of Change
    /**
     * Updates the ship image. Particuarly change texture on college destruction
     *
     * @param alignment Associated college
     * @param path Path of new texture
     */
    public void updateTexture(String alignment, String path){
        college = alignment;
        enemyShip = new Texture(path);
        setRegion(enemyShip);
    }
}
