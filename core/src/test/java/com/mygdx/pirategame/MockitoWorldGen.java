package com.mygdx.pirategame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.pirategame.entities.Player;
import com.mygdx.pirategame.hud.Hud;
import com.mygdx.pirategame.hud.audioControls;
import com.mygdx.pirategame.main.PirateGame;
import com.mygdx.pirategame.screens.GameScreen;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

/**
 * mock specific classes within the game
 */
public class MockitoWorldGen {

    public static boolean gameStatus = false;

    /**
     * Used to mock the Hud class so all the static methods can be used
     */
    public static void mockHudStatic() {
        Hud hud = Mockito.mock(Hud.class);

        Whitebox.setInternalState(hud, "scoreLabel", new Label(String.format("%03d", 0), new Label.LabelStyle(new BitmapFont(), Color.WHITE)));
        Whitebox.setInternalState(hud, "coinLabel", new Label(String.format("%03d", 0), new Label.LabelStyle(new BitmapFont(), Color.YELLOW)));
        Whitebox.setInternalState(hud, "powerupTypeText", new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE)));
        Whitebox.setInternalState(hud, "coinMulti", 1);
        Whitebox.setInternalState(hud, "pointMulti", 1);
        
        // setting up score and coins to 0
        Hud.setPoints(0);
        Hud.setCoins(0);
        Hud.setHealth(100);
    }

    
    /**
     * Used to mock the base game class
     * @return The created game
     */
    public static PirateGame mockGame() {
		PirateGame pirateGame = Mockito.mock(PirateGame.class);

		audioControls AudioControls = new audioControls();

		Whitebox.setInternalState(pirateGame, "options", AudioControls);
		Mockito.when(pirateGame.getPreferences()).thenReturn(AudioControls);

		return pirateGame;
	}
    
    /**
     * Used to mock the game screen so it can be used in tests
     * @return The created game screen
     */
    public static GameScreen mockGameScreen() {
        // creating required variables, and mocking return values
        GameScreen screen = Mockito.mock(GameScreen.class);
        
        Mockito.when(screen.getWorld()).thenReturn(new World(new Vector2(0, 0), true));
        
        //audioControls options = Mockito.mock(audioControls.class);
        //Whitebox.setInternalState(screen, "options", options);
        //audioControls options = new audioControls();
          
        //boolean b = options.isEffectsEnabled();
        
        //Mockito.when(GameScreen.game.getPreferences().isEffectsEnabled()).thenReturn(false);

        TmxMapLoader mapLoader = new TmxMapLoader();
        TiledMap map = mapLoader.load("map/map.tmx");
        Mockito.when(screen.getMap()).thenReturn(map);

        // Mock camera with the same config as the actual game camera
        OrthographicCamera camera = new OrthographicCamera();
        camera.zoom = 0.0155f;
        FitViewport viewport = new FitViewport(1280, 720, camera);
        camera.position.set(viewport.getWorldWidth() / 3, viewport.getWorldHeight() / 3, 0);

        return screen;
    }

    /**
     * Used to mock the game screen with the player position also mocked
     * @return the created GameScreen instance
     */
    public static GameScreen mockGameScreenWithPlayer() {
        GameScreen screen = mockGameScreen();

        Mockito.when(screen.getPlayerPos()).thenReturn(new Vector2(13*64 / PirateGame.PPM, 11*64 / PirateGame.PPM));
        Mockito.when(screen.checkGenPos(Mockito.anyInt(),Mockito.anyInt())).thenReturn(true);

        return screen;
    }
}