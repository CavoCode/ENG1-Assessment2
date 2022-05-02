package com.mygdx.pirategame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.pirategame.main.PirateGame;

/**
 * Screen with instructions for the user
 * @author Sam Pearson
 * @version 1.0
 */
public class Help implements Screen {
    private final PirateGame parent;
    private final Stage stage;
    public Integer page = 1; //Team 17 - used to remember which help page it's on

    /**
     * In the constructor, the parent and stage are set. Also the states list is set
     *
     * @param pirateGame Game data
     */
    public Help(PirateGame pirateGame){
        parent = pirateGame;
        stage = new Stage(new ScreenViewport());
    }

    /**
     * Displays help data
     */
    @Override
    public void show() {
        //Set the input processor
        Gdx.input.setInputProcessor(stage);
        // Create a table that fills the screen
        final Table table1 = new Table(); //Team 17 - changed to final
        table1.setFillParent(true);
        stage.addActor(table1);

        //Team 17 ----- 
        //create table pages
        final Table table2 = new Table();
        final Table table3 = new Table();
        table2.setFillParent(true);
        stage.addActor(table2);
        table3.setFillParent(true);
        stage.addActor(table3);
        //-------------

        // Table for the return button
        final Table Other1 = new Table();
        Other1.setFillParent(true);
        stage.addActor(Other1);

        //Team 17 ----------
        final Table Other2 = new Table();
        Other2.setFillParent(true);
        stage.addActor(Other2);
        //------------------

        //The skin for the actors
        Skin skin = new Skin(Gdx.files.internal("skin\\uiskin.json"));

        //Team 17 - added if statement to allow for different pages
        if (page == 1){

            //Text
            Label Controls1 = new Label("WASD to move", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label Controls2 = new Label("E to fire", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label Controls3 = new Label("ESCAPE to see menu", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label objective1 = new Label("The objective is to take over or destroy all other colleges", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label objective2 = new Label("Destroy the college flag with cannons", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label objective3 = new Label("Collect coins on the way", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            //Team 17 - changed skillInfo1 text since skill tab changed it's purpose
            Label skillInfo1 = new Label("Unlock upgrades you can purchase for coins", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label skillInfo2 = new Label("See your upgrades in the skills tab", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            
            //Team 17--------
            //-moved code from elsewhere
            //Adds text into table
            Other1.add(Controls1);
            Other1.row();
            Other1.add(Controls2);
            Other1.row();
            Other1.add(Controls3).padBottom((40));
            Other1.row();
            Other1.add(objective1);
            Other1.row();
            Other1.add(objective2);
            Other1.row();
            Other1.add(objective3).padBottom((40));
            Other1.row();
            Other1.add(skillInfo1);
            Other1.row();
            Other1.add(skillInfo2).padBottom((40));
            Other1.center();
            //---------------

            //Team 17-----------
            //Making a next page button
            TextButton nextPage = new TextButton("Next", skin);
            nextPage.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    //Sets next page and changes visibility of text
                    page = 2;
                    Other1.remove();
                    table2.remove();
                    parent.changeScreen(PirateGame.HELP);
                }
            });
            //Adds button to table and sets location
            table2.add(nextPage);
            table2.row().pad(10, 0, 10, 0);
            table2.right().bottom();
            //-----------------
        }
        else if (page == 2){
            //--------Team 17---------------

            //text
            Label powerup1 = new Label("Collect powerups for temporary special effects", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label powerup2 = new Label("There are 5 random effects to recieve", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label weather1 = new Label("Sometimes Bad-Weather will appear across the whole map", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label weather2 = new Label("This will slow down all ships and obscure your vision", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label weather3= new Label("But the points you can recieve are doubled", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            Label weather4= new Label("Additional powerups and coins will rise to the surface", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
            
            //add labels
            Other2.add(powerup1);
            Other2.row();
            Other2.add(powerup2).padBottom((40));
            Other2.row();
            Other2.add(weather1);
            Other2.row();
            Other2.add(weather2);
            Other2.row();
            Other2.add(weather3);
            Other2.row();
            Other2.add(weather4).padBottom((40));
            Other2.center();

            //Making previous page button
            TextButton prevPage = new TextButton("Previous", skin);
            prevPage.addListener(new ChangeListener() {

                @Override
                public void changed(ChangeEvent event, Actor actor) {
                    //Changes page and visibility of text
                    page = 1;
                    Other2.remove();
                    table3.remove();
                    parent.changeScreen(PirateGame.HELP);
                }
            });
            //Adds button to table and sets location
            table3.add(prevPage);
            table3.row().pad(10, 0, 10, 0);
            table3.left().bottom();
            //-----------------------------
        }
        //Return Button
        TextButton backButton = new TextButton("Return", skin);
        backButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(PirateGame.MENU);
                //Team 17---------
                if (page==1){
                    table2.remove();
                    Other1.remove();
                }
                else if (page==2){
                    table3.remove();
                    Other2.remove();
                }
                //----------------
            }
        });
        //add return button
        table1.add(backButton);
        table1.row().pad(10, 0, 10, 0);
        table1.left().top();
    }

    /**
     * Renders visual data with delta time
     *
     * @param dt Delta time (elapsed time since last game tick)
     */
    @Override
    public void render(float dt) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        // TODO Auto-generated method stub
    }

    /**
     * Changes the camera size
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




