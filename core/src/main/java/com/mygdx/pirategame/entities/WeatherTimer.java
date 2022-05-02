package com.mygdx.pirategame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.pirategame.entities.Enemy;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class WeatherTimer {
    private Sprite weatherBar;
    private Texture image;

    private Image weather;


    public WeatherTimer(Image weather){
        this.weather = weather;
        image = new Texture("hud/HealthBar.png");
        weatherBar = new Sprite(image);
        //Sets size of the weather bar
        weatherBar.setScale(weather.getScaleX(), weather.getScaleY());
        weatherBar.setSize(weatherBar.getWidth() - 2f,  weatherBar.getHeight() - 2f);

        //Sets location of bar
        weatherBar.setX (this.weather.getScaleY() / 2);
        weatherBar.setY(4 * this.weather.getScaleY() / 5);
        weatherBar.setOrigin(0,0);
    }
    /**
     * Updates weatherTimer
     */
    public void update(){
        //Update size and location (in case of window size change)
        weatherBar.setScale(2 * weather.getScaleX()/3, weather.getScaleY()/10);
        weatherBar.setSize(weatherBar.getWidth() - 2f,  weatherBar.getHeight() - 2f);

        weatherBar.setX (this.weather.getScaleY() / 2);
        weatherBar.setY(4 * this.weather.getScaleY() / 5);
    }

    /**
     * Renders weather bar
     */
    public void render(Batch batch){
        weatherBar.draw(batch);
    }

    /**
     * Updates weatherbar with regards to damage
     *
     * @param value Damage recieved
     */
    public void changeTime(float value){
        //Changes bar size when damaged
        weatherBar.setSize(weatherBar.getWidth() - value, weatherBar.getHeight());
    }
}
