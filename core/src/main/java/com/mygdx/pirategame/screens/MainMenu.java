package com.mygdx.pirategame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.pirategame.main.PirateGame;

/**
 * Main menu is the first screen the player sees. Allows them to navigate where they want to go to
 * @author Sam Pearson
 * @version 1.0
 */
public class MainMenu implements Screen {

    private final PirateGame parent;
    private GameScreen gameScreen;
    private final Stage stage;
    private ShapeRenderer shapeRenderer;
    private Image backgroundImg;
    private Texture background;
    public static String difficulty;

    /**
     * Instantiates a new Main menu.
     *
     * @param PirateGame the main starting body of the game. Where screen swapping is carried out.
     */
    public MainMenu(PirateGame PirateGame){
        parent = PirateGame;
        stage = new Stage(new ScreenViewport());
    }

    /**
     * What should be displayed on the options screen
     *
     */
    @Override
    public void show() {
        //Set the input processor
        Gdx.input.setInputProcessor(stage);
        //Create texture for background image
        background = new Texture("hud/mainScreen.jpg"); 
        backgroundImg = new Image(background);
        backgroundImg.setFillParent(true);
        //Create a table for the background image
        Table backgroundTable = new Table();
        backgroundTable.top().right();
        backgroundTable.setFillParent(true);
        //Add image to table
        backgroundTable.add(backgroundImg);
        //setVisible here
        stage.addActor(backgroundImg);
        
        // Create a table for the buttons
        final Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        //The skin for the actors
        Skin skin = new Skin(Gdx.files.internal("skin\\uiskin.json"));

        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        TextButton help = new TextButton("Help", skin);
        TextButton options = new TextButton("Options", skin);
        TextButton exit = new TextButton("Exit", skin);

        //add buttons to table
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(help).fillX().uniformX();
        table.row();
        table.add(options).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();
        
        // Create a table for difficulty buttons
        final Table difficultyTable = new Table();
        difficultyTable.setFillParent(true);
        stage.addActor(difficultyTable);
        
        // Create difficulty buttons
        TextButton easy = new TextButton("Easy Mode", skin);
        TextButton normal = new TextButton("Normal Mode", skin);
        TextButton hard = new TextButton("Hard Mode", skin);

        // Add buttons to difficulty table
        difficultyTable.add(easy).fillX().uniformX();
        difficultyTable.row().pad(10, 0, 10, 0);
        difficultyTable.add(normal).fillX().uniformX();
        difficultyTable.row();
        difficultyTable.add(hard).fillX().uniformX();
        difficultyTable.row();
        
        // Set difficulty table invisible for now
        difficultyTable.setVisible(false);
        
        //add listeners to the buttons

        //Start a game - ask for difficulty
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
            	table.setVisible(false);
            	difficultyTable.setVisible(true);
                //parent.changeScreen(PirateGame.GAME);
            }
        });
        
        //Start an easy game
        easy.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
            	difficulty = "easy";
                parent.changeScreen(PirateGame.GAME);
            }
        });
        
      //Start a normal game
        normal.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
            	difficulty = "normal";
                parent.changeScreen(PirateGame.GAME);
            }
        });
        
      //Start an hard game
        hard.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
            	difficulty = "hard";
                parent.changeScreen(PirateGame.GAME);
            }
        });
        
        //Help Screen
        help.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                parent.changeScreen(PirateGame.HELP);
            }
        });

        //Go to edit options
        options.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor){
                parent.setScreen(new Options(parent,parent.getScreen()));
            }
        });


        //Quit game
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

    }
    
    public static String getDifficulty() {
    	return difficulty;
    }

    /**
     * Renders the visual data for all objects
     * @param delta Delta Time
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glDisable(GL20.GL_BLEND);
        
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




