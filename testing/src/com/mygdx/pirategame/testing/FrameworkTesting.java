package com.mygdx.pirategame.testing;

import com.badlogic.gdx.Gdx;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(GdxTestRunner.class)
public class FrameworkTesting {

    @Test
    public void shouldBeTrue() {
        //assertTrue("This test will only pass when the ship.png asset exists.", Gdx.files
        //        .internal("ship.png").exists());
	assertTrue(true);
    }
    
    @Test
    public void shouldBeFalse() {
        //assertTrue("This test will only pass when the ship.png asset exists.", Gdx.files
        //        .internal("ship.png").exists());
	assertTrue(false);
    }
}
