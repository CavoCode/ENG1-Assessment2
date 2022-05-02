package com.mygdx.pirategame.hud;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.screens.SkillTree;
import com.mygdx.pirategame.screens.GameScreen;

/**
 * Hud
 * Produces a hud for the player
 *
 *@author Ethan Alabaster, Sam Pearson
 *@version 1.0
 */
public class Hud implements Disposable {
    public static Stage stage;
    private Viewport viewport;

    private float timeCount;
    private static Integer score;
    private static Integer health;
    private static Integer maxHealth;
    private Texture hp;
    private Texture boxBackground;
    private Texture coinPic;
    private Texture weatherHud; //Team 17
    public static Integer weatherTimer; //Team 17 - Change back to private once done testing
    private static boolean countDown; //Team 17
    private static Integer pointMulti; //Team 17

    private static Label scoreLabel;
    private static Label healthLabel;
    private static Label coinLabel;
    private static Label pointsText;
    private static Label powerupTypeText;
    private static Integer coins;
    private static Integer coinMulti;
    private Image hpImg;
    private Image box;
    private Image coin;
    private Image weather; //Team 17

    /**
     * Retrieves information and displays it in the hud
     * Adjusts hud with viewport
     *
     * @param sb Batch of images used in the hud
     */
    public Hud(SpriteBatch sb) {
    	maxHealth = 100;
    	health = maxHealth;
        score = 0;
        coins = 0;
        coinMulti = 1;
        //Set images
        hp = new Texture("hud/hp.png");
        boxBackground = new Texture("hud/hudBG.png");
        coinPic = new Texture("coin.png");

        hpImg = new Image(hp);
        box = new Image(boxBackground);
        coin = new Image(coinPic);

        viewport = new ScreenViewport();
        stage = new Stage(viewport, sb);

        //Creates tables
        Table table1 = new Table(); //Counters
        Table table2 = new Table(); //Pictures or points label
        Table table3 = new Table(); //Background
        Table table4 = new Table(); //Powerups

        table1.top().right();
        table1.setFillParent(true);
        table2.top().right();
        table2.setFillParent(true);
        table3.top().right();
        table3.setFillParent(true);
        table4.top().center();
        table4.setFillParent(true);

        scoreLabel = new Label(String.format("%03d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthLabel = new Label(String.format("%03d", health), new Label.LabelStyle(new BitmapFont(), Color.RED));
        coinLabel = new Label(String.format("%03d", coins), new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        pointsText = new Label("Points:", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        powerupTypeText = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table4.add(powerupTypeText).height(32).padBottom(90);
        table3.add(box).width(140).height(140).padBottom(15).padLeft(30);
        table2.add(hpImg).width(32).height(32).padTop(16).padRight(90);
        table2.row();
        table2.add(coin).width(32).height(32).padTop(8).padRight(90);
        table2.row();
        table2.add(pointsText).width(32).height(32).padTop(6).padRight(90);
        table1.add(healthLabel).padTop(20).top().right().padRight(40);
        table1.row();
        table1.add(coinLabel).padTop(20).top().right().padRight(40);
        table1.row();
        table1.add(scoreLabel).padTop(22).top().right().padRight(40);
        

        //Team 17-----
        //Setup weather texture
        weatherHud = new Texture("hud/weathering.png"); 
        weather = new Image(weatherHud);
        weather.setFillParent(true);

        //Add weather texture to screen
        stage.addActor(weather);
        //Make it invisible
        weather.setVisible(false);

        countDown = false;
        weatherTimer = 0;
        pointMulti = 1;
        //------------
        stage.addActor(table4);
        stage.addActor(table3);
        stage.addActor(table2);
        stage.addActor(table1);
    }

    /**
     * Updates the state of the hud
     *
     * @param dt Delta time (elapsed time since last game tick)
     */
    public void update(float dt) {
        timeCount += dt;
        if(timeCount >= 1) {
			// Regen health every second
			if (Player.soup) {
				health += 2;
			}
			health += 1;
			if (health > maxHealth) {
				health = maxHealth;
			}
			healthLabel.setText(String.format("%02d", health));
            //Gain point every second
            score += 1;
            scoreLabel.setText(String.format("%03d", score));
            timeCount = 0;

            //Check if a points boundary is met
            SkillTree.pointsCheck(score);

            //TEAM 17-------------
            
            //Checks if the weather is counting up or down
            if (!countDown){
                //Counts up
                weatherTimer += 1;
            }
            else{
                //Counts down
                weatherTimer -= 2;
            }

            //Checks to see if the weather counter has passed either boundary
            if (weatherTimer > 100){
                //starts weather event
                weatherTimer = 100;
                GameScreen.weather(true);
                weather.setVisible(true);
                //starts counting down
                countDown = true;
                //Points gained is doubled
                pointMulti = 2;
            }
            else if (weatherTimer < 0){
                //Stops weather event
                weatherTimer = 0;
                GameScreen.weather(false);
                weather.setVisible(false);
                //Starts counting up
                countDown = false;
                //Points gained is normal
                pointMulti = 1;
            }
            //------------------
        }
    }

    /**
     * Changes health by value increase
     *
     * @param value Increase to health
     */
    public static void changeHealth(int value) {
        health += value;
        healthLabel.setText(String.format("%02d", health));
    }
    
    public static void changeMaxHealth(int value) {
    	maxHealth = value;
        healthLabel.setText(String.format("%02d", maxHealth));
    }

    /**
     * Changes coins by value increase
     *
     * @param value Increase to coins
     */
    public static void changeCoins(int value) {
        if (value > 0) {
            coins += value * coinMulti;
            coinLabel.setText(String.format("%03d", coins));
        }
    }

    /**
     * Changes points by value increase
     *
     * @param value Increase to points
     */
    public static void changePoints(int value) {
        //Team 17- added pointMulti
        score += value * pointMulti;
        scoreLabel.setText(String.format("%03d", score));
        //Check if a points boundary is met
        SkillTree.pointsCheck(score);
    }

    /**
     * Changes health by value factor
     *
     * @param value Factor of coin increase
     */
    public static void changeCoinsMulti(int value) {
        coinMulti = coinMulti * value;
    }
    
    /**
     * Changes Powerup Text - use empty string to make disappear
     * 
     * @param type the text to be displayed as the power up type
     */
    public static void setPowerupType(String type) {
    	powerupTypeText.setText(type);
    }

    /**
     * Changes the camera size, Scales the hud to match the camera
     *
     * @param width the width of the viewable area
     * @param height the height of the viewable area
     */
    public static void resize(int width, int height){
        stage.getViewport().update(width, height, true);
    }

    /**
     * Returns health value
     *
     * @return health : returns health value
     */
    public static Integer getHealth(){
        return health;
    }
    
    public static void setHealth(Integer hp) {
    	health = hp; 
    }
    
    public static void setCoins(Integer Coins) {
    	coins = Coins; 
    }

    /**
     * (Not Used)
     * Returns coins value
     *
     * @return health : returns coins value
     */
    public static Integer getCoins(){
        return coins;
    }

    /**
     * Disposes game data
     */
    @Override
    public void dispose() {
        stage.dispose();
    }

}

