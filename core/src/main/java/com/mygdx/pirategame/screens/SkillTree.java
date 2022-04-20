package com.mygdx.pirategame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * The type for the skill tree screen.
 * It is a visual representation for the skills that the game automatically unlocks for the player.
 * Automatically unlocked when a points threshold is reached
 *
 * @author Sam Pearson
 * @version 1.0
 */
public class SkillTree implements Screen {

    private final PirateGame parent;
    private final Stage stage;

    //To store whether buttons are enabled or disabled
    private static final List<Integer> states = new ArrayList<Integer>();

    //edited by Team 17-sabrina
    //create labels for powerups
    private static TextButton HealHealth;
    private TextButton CannonDamage;
    private TextButton Acceleration;
    private TextButton ExtraLives;
    private TextButton GoldMultiplier;
    

    /**
     * Instantiates a new Skill tree.
     *
     * @param pirateGame the main starting body of the game. Where screen swapping is carried out.
     */
//In the constructor, the parent and stage are set. Also the states list is set
    public SkillTree(PirateGame pirateGame){
        parent = pirateGame;
        stage = new Stage(new ScreenViewport());

        //0 = enabled, 1 = disabled
        states.add(1);
        states.add(1);
        states.add(1);
        states.add(1);
        states.add(1);
    }
    /**
     * What should be displayed on the skill tree screen
     *
     */
    @Override
    public void show() {
        //Set the input processor
        Gdx.input.setInputProcessor(stage);
        // Create a table that fills the screen
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        stage.addActor(table);


        // Table for the return button
        final Table Other = new Table();
        Other.setFillParent(true);
        stage.addActor(Other);


        //The skin for the actors
        Skin skin = new Skin(Gdx.files.internal("skin\\uiskin.json"));

        //create skill tree labels
        HealHealth = new TextButton("Repair Ship + 20%", skin);  
        if (states.get(0) == 1){
            HealHealth.setDisabled(true);
        }
        HealHealth.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	Hud.changeHealth(20);
            	
            }
        });

        Acceleration = new TextButton("Increase Speed + 20%", skin);  
        //Set enabled. if 1 locked if 0 unlocked
        if (states.get(0) == 1){
            Acceleration.setDisabled(true);
        }
        Acceleration.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	//Change acceleration
                GameScreen.changeAcceleration(20F);
                //Change Max speed
                GameScreen.changeMaxSpeed(20F);
                Hud.changeCoins(-10);
            }
        });

        ExtraLives = new TextButton("Reinforce Ships Hull + 20%", skin);
        if (states.get(2) == 1){
            ExtraLives.setDisabled(true);
        }
        ExtraLives.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	Hud.changeMaxHealth(10);
            	Hud.changeCoins(-10);
            }
        });

        CannonDamage = new TextButton("Damage + 5", skin);
        if (states.get(3) == 1){
            CannonDamage.setDisabled(true);
        }
        CannonDamage.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	GameScreen.changeDamage(5);
            	Hud.changeCoins(-5);
            }
        });
        GoldMultiplier = new TextButton("Gold Multiplier x2", skin);  
        if (states.get(4) == 1){
        	GoldMultiplier.setDisabled(true);
        }
        GoldMultiplier.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
            	 //change gold multiplier 
            	Hud.changeCoinsMulti(2);
            	Hud.changeCoins(-50);
            }
        });

        //Point unlock labels
        final Label unlock25 = new Label("$25",skin);
        final Label unlock50 = new Label("$50",skin);
        final Label unlock75 = new Label("$75",skin);
        final Label unlock100 = new Label("$100",skin);
        
        
        //Return Button
        TextButton backButton = new TextButton("Return", skin);

        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                parent.changeScreen(PirateGame.GAME); //Return to game
            }
        });

        //add buttons and labels to main table
        table.add(HealHealth);
        table.add(unlock25);
        table.row().pad(10, 0, 10, 0);
        table.add(Acceleration);
        table.add(unlock50);
        table.row().pad(10, 0, 10, 0);
        table.add(ExtraLives);
        table.add(unlock75);
        table.row().pad(10, 0, 10, 0);
        table.add(CannonDamage);
        table.add(unlock100);
        table.row().pad(10, 0, 10, 0);
        table.add(GoldMultiplier);
        table.add(unlock100);
        table.row().pad(10, 0, 10, 0);
        table.center();

        //add return button
        Other.add(backButton);
        Other.bottom().left();
    }

    /**
     * Allows the game to check whether a points threshold has been reached
     *
     * @param points the current amount of points
     */
    public static void pointsCheck(int points){
    	        //States.get() checks whether it has already been unlocked. 1 = not unlocked, 0 = unlocked
    	        if(states.get(0) == 1 && points >= 25 && Hud.getCoins() >= 5){
    	            states.set(0, 0);
    	        }
    	        else if(states.get(1) == 1 && points >= 50 && Hud.getCoins() >= 10){
    	            states.set(1, 0);
    	        }
    	        else if(states.get(2) == 1 && points >= 15 && Hud.getCoins() >= 10){
    	            states.set(2, 0);
    	        }else if(states.get(3) == 1 && points >= 10 && Hud.getCoins() >= 5){
    	            states.set(3, 0);
    	        }else if(states.get(4) == 1 && points >= 100 && Hud.getCoins() >= 25){
    	            states.set(4, 0);
    	        }
    	    }


    /**
     * Renders the visual data for all objects
     * @param delta Delta Time
     */

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    /**
     * Changes the camera size, Scales the hud to match the camera
     *
     * @param width the width of the viewable area
     * @param height the height of the viewable area
     */
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    /**
     * (Not Used)
     * Pauses game
     */
    @Override
    public void pause() {
    }
    /**
     * (Not Used)
     * Resumes game
     */
    @Override
    public void resume() {
    }
    /**
     * (Not Used)
     * Hides game
     */
    @Override
    public void hide() {
    }
    /**
     * Disposes game data
     */
    @Override
    public void dispose() {
        stage.dispose();
    }
}




