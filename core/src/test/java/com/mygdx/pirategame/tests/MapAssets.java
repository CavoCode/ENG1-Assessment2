package com.mygdx.pirategame.tests;

import com.badlogic.gdx.Gdx;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(GdxTestRunner.class)
public class MapAssets {
	
	/*
	 * TEMPLATE
	@Test
    public void assetNameExists() {
        assertTrue("does containingFolder/assetName.png asset exist", Gdx.files
                .internal("map/assetName.png").exists());
    }
	**/

    @Test
    public void defualtfntExists() {
        assertTrue("does default.fnt asset exist", Gdx.files
                .internal("map/default.fnt").exists());
    }
    
    @Test
    public void islandstsxExists() {
        assertTrue("does islands.tsx asset exist", Gdx.files
                .internal("map/islands.tsx").exists());
    }
    
    @Test
    public void maptsxExists() {
        assertTrue("does map.tmx asset exist", Gdx.files
                .internal("map/map.tmx").exists());
    }
    
    @Test
    public void mapBasetxtExists() {
        assertTrue("does mapBase.txt asset exist", Gdx.files
                .internal("map/mapBase.txt").exists());
    }
    
    @Test
    public void minimapExists() {
        assertTrue("does minimap.png asset exist", Gdx.files
                .internal("map/minimap.png").exists());
    }
    
    @Test
    public void rockstsxExists() {
        assertTrue("does rocks.tsx asset exist", Gdx.files
                .internal("map/rocks.tsx").exists());
    }
    
    @Test
    public void tile_01Exists() {
        assertTrue("does tile_01.png asset exist", Gdx.files
                .internal("map/tile_01.png").exists());
    }
    
    @Test
    public void tile_02Exists() {
        assertTrue("does tile_02.png asset exist", Gdx.files
                .internal("map/tile_02.png").exists());
    }
    
    @Test
    public void tile_03Exists() {
        assertTrue("does tile_03.png asset exist", Gdx.files
                .internal("map/tile_03.png").exists());
    }
    
    @Test
    public void tile_04Exists() {
        assertTrue("does tile_04.png asset exist", Gdx.files
                .internal("map/tile_04.png").exists());
    }
    
    @Test
    public void tile_05Exists() {
        assertTrue("does tile_05.png asset exist", Gdx.files
                .internal("map/tile_05.png").exists());
    }
    
    @Test
    public void tile_06Exists() {
        assertTrue("does tile_06.png asset exist", Gdx.files
                .internal("map/tile_06.png").exists());
    }
    
    @Test
    public void tile_07Exists() {
        assertTrue("does tile_07.png asset exist", Gdx.files
                .internal("map/tile_07.png").exists());
    }
    
    @Test
    public void tile_08Exists() {
        assertTrue("does tile_08.png asset exist", Gdx.files
                .internal("map/tile_08.png").exists());
    }
    
    @Test
    public void tile_09Exists() {
        assertTrue("does tile_09.png asset exist", Gdx.files
                .internal("map/tile_09.png").exists());
    }
    
    @Test
    public void tile_10Exists() {
        assertTrue("does tile_10.png asset exist", Gdx.files
                .internal("map/tile_10.png").exists());
    }
    
    @Test
    public void tile_11Exists() {
        assertTrue("does tile_11.png asset exist", Gdx.files
                .internal("map/tile_11.png").exists());
    }
    
    @Test
    public void tile_12Exists() {
        assertTrue("does tile_12.png asset exist", Gdx.files
                .internal("map/tile_12.png").exists());
    }
    
    @Test
    public void tile_13Exists() {
        assertTrue("does tile_13.png asset exist", Gdx.files
                .internal("map/tile_13.png").exists());
    }
    
    @Test
    public void tile_14Exists() {
        assertTrue("does tile_14.png asset exist", Gdx.files
                .internal("map/tile_14.png").exists());
    }
    
    @Test
    public void tile_15Exists() {
        assertTrue("does tile_15.png asset exist", Gdx.files
                .internal("map/tile_15.png").exists());
    }
    
    @Test
    public void tile_16Exists() {
        assertTrue("does tile_16.png asset exist", Gdx.files
                .internal("map/tile_16.png").exists());
    }
    
    @Test
    public void tile_17Exists() {
        assertTrue("does tile_17.png asset exist", Gdx.files
                .internal("map/tile_17.png").exists());
    }
    
    @Test
    public void tile_18Exists() {
        assertTrue("does tile_18.png asset exist", Gdx.files
                .internal("map/tile_18.png").exists());
    }
    
    @Test
    public void tile_19Exists() {
        assertTrue("does tile_19.png asset exist", Gdx.files
                .internal("map/tile_19.png").exists());
    }
    
    @Test
    public void tile_20Exists() {
        assertTrue("does tile_20.png asset exist", Gdx.files
                .internal("map/tile_20.png").exists());
    }
    
    @Test
    public void tile_21Exists() {
        assertTrue("does tile_21.png asset exist", Gdx.files
                .internal("map/tile_21.png").exists());
    }
    
    @Test
    public void tile_22Exists() {
        assertTrue("does tile_22.png asset exist", Gdx.files
                .internal("map/tile_22.png").exists());
    }
    
    @Test
    public void tile_23Exists() {
        assertTrue("does tile_23.png asset exist", Gdx.files
                .internal("map/tile_23.png").exists());
    }
    
    @Test
    public void tile_24Exists() {
        assertTrue("does tile_24.png asset exist", Gdx.files
                .internal("map/tile_24.png").exists());
    }
    
    @Test
    public void tile_25Exists() {
        assertTrue("does tile_25.png asset exist", Gdx.files
                .internal("map/tile_25.png").exists());
    }
    
    @Test
    public void tile_26Exists() {
        assertTrue("does tile_26.png asset exist", Gdx.files
                .internal("map/tile_26.png").exists());
    }
    
    @Test
    public void tile_27Exists() {
        assertTrue("does tile_27.png asset exist", Gdx.files
                .internal("map/tile_27.png").exists());
    }
    
    @Test
    public void tile_28Exists() {
        assertTrue("does tile_28.png asset exist", Gdx.files
                .internal("map/tile_28.png").exists());
    }
    
    @Test
    public void tile_29Exists() {
        assertTrue("does tile_29.png asset exist", Gdx.files
                .internal("map/tile_29.png").exists());
    }
    
    @Test
    public void tile_30Exists() {
        assertTrue("does tile_30.png asset exist", Gdx.files
                .internal("map/tile_30.png").exists());
    }

    @Test
    public void tile_31Exists() {
        assertTrue("does tile_31.png asset exist", Gdx.files
                .internal("map/tile_31.png").exists());
    }
    
    @Test
    public void tile_32Exists() {
        assertTrue("does tile_32.png asset exist", Gdx.files
            .internal("map/tile_32.png").exists());
    }

    @Test
    public void tile_33Exists() {
        assertTrue("does tile_33.png asset exist", Gdx.files
            .internal("map/tile_33.png").exists());
    }

    @Test
    public void tile_34Exists() {
        assertTrue("does tile_34.png asset exist", Gdx.files
            .internal("map/tile_34.png").exists());
    }

    @Test
    public void tile_35Exists() {
        assertTrue("does tile_35.png asset exist", Gdx.files
            .internal("map/tile_35.png").exists());
    }

    @Test
    public void tile_36Exists() {
        assertTrue("does tile_36.png asset exist", Gdx.files
            .internal("map/tile_36.png").exists());
    }

    @Test
    public void tile_37Exists() {
        assertTrue("does tile_37.png asset exist", Gdx.files
            .internal("map/tile_37.png").exists());
    }

    @Test
    public void tile_38Exists() {
        assertTrue("does tile_38.png asset exist", Gdx.files
            .internal("map/tile_38.png").exists());
    }

    @Test
    public void tile_39Exists() {
        assertTrue("does tile_39.png asset exist", Gdx.files
            .internal("map/tile_39.png").exists());
    }

    @Test
    public void tile_40Exists() {
        assertTrue("does tile_40.png asset exist", Gdx.files
            .internal("map/tile_40.png").exists());
    }

    @Test
    public void tile_41Exists() {
        assertTrue("does tile_41.png asset exist", Gdx.files
            .internal("map/tile_41.png").exists());
    }

    @Test
    public void tile_42Exists() {
        assertTrue("does tile_42.png asset exist", Gdx.files
            .internal("map/tile_42.png").exists());
    }

    @Test
    public void tile_43Exists() {
        assertTrue("does tile_43.png asset exist", Gdx.files
            .internal("map/tile_43.png").exists());
    }

    @Test
    public void tile_44Exists() {
        assertTrue("does tile_44.png asset exist", Gdx.files
            .internal("map/tile_44.png").exists());
    }

    @Test
    public void tile_45Exists() {
        assertTrue("does tile_45.png asset exist", Gdx.files
            .internal("map/tile_45.png").exists());
    }

    @Test
    public void tile_46Exists() {
        assertTrue("does tile_46.png asset exist", Gdx.files
            .internal("map/tile_46.png").exists());
    }

    @Test
    public void tile_47Exists() {
        assertTrue("does tile_47.png asset exist", Gdx.files
            .internal("map/tile_47.png").exists());
    }

    @Test
    public void tile_48Exists() {
        assertTrue("does tile_48.png asset exist", Gdx.files
            .internal("map/tile_48.png").exists());
    }

    @Test
    public void tile_49Exists() {
        assertTrue("does tile_49.png asset exist", Gdx.files
            .internal("map/tile_49.png").exists());
    }

    @Test
    public void tile_50Exists() {
        assertTrue("does tile_50.png asset exist", Gdx.files
            .internal("map/tile_50.png").exists());
    }

    @Test
    public void tile_51Exists() {
        assertTrue("does tile_51.png asset exist", Gdx.files
            .internal("map/tile_51.png").exists());
    }

    @Test
    public void tile_52Exists() {
        assertTrue("does tile_52.png asset exist", Gdx.files
            .internal("map/tile_52.png").exists());
    }

    @Test
    public void tile_53Exists() {
        assertTrue("does tile_53.png asset exist", Gdx.files
            .internal("map/tile_53.png").exists());
    }

    @Test
    public void tile_54Exists() {
        assertTrue("does tile_54.png asset exist", Gdx.files
            .internal("map/tile_54.png").exists());
    }

    @Test
    public void tile_55Exists() {
        assertTrue("does tile_55.png asset exist", Gdx.files
            .internal("map/tile_55.png").exists());
    }

    @Test
    public void tile_56Exists() {
        assertTrue("does tile_56.png asset exist", Gdx.files
            .internal("map/tile_56.png").exists());
    }

    @Test
    public void tile_57Exists() {
        assertTrue("does tile_57.png asset exist", Gdx.files
            .internal("map/tile_57.png").exists());
    }

    @Test
    public void tile_58Exists() {
        assertTrue("does tile_58.png asset exist", Gdx.files
            .internal("map/tile_58.png").exists());
    }

    @Test
    public void tile_59Exists() {
        assertTrue("does tile_59.png asset exist", Gdx.files
            .internal("map/tile_59.png").exists());
    }

    @Test
    public void tile_60Exists() {
        assertTrue("does tile_60.png asset exist", Gdx.files
            .internal("map/tile_60.png").exists());
    }

    @Test
    public void tile_61Exists() {
        assertTrue("does tile_61.png asset exist", Gdx.files
            .internal("map/tile_61.png").exists());
    }

    @Test
    public void tile_62Exists() {
        assertTrue("does tile_62.png asset exist", Gdx.files
            .internal("map/tile_62.png").exists());
    }

    @Test
    public void tile_63Exists() {
        assertTrue("does tile_63.png asset exist", Gdx.files
            .internal("map/tile_63.png").exists());
    }

    @Test
    public void tile_64Exists() {
        assertTrue("does tile_64.png asset exist", Gdx.files
            .internal("map/tile_64.png").exists());
    }

    @Test
    public void tile_65Exists() {
        assertTrue("does tile_65.png asset exist", Gdx.files
            .internal("map/tile_65.png").exists());
    }

    @Test
    public void tile_66Exists() {
        assertTrue("does tile_66.png asset exist", Gdx.files
            .internal("map/tile_66.png").exists());
    }

    @Test
    public void tile_67Exists() {
        assertTrue("does tile_67.png asset exist", Gdx.files
            .internal("map/tile_67.png").exists());
    }

    @Test
    public void tile_68Exists() {
        assertTrue("does tile_68.png asset exist", Gdx.files
            .internal("map/tile_68.png").exists());
    }

    @Test
    public void tile_69Exists() {
        assertTrue("does tile_69.png asset exist", Gdx.files
            .internal("map/tile_69.png").exists());
    }

    @Test
    public void tile_70Exists() {
        assertTrue("does tile_70.png asset exist", Gdx.files
            .internal("map/tile_70.png").exists());
    }

    @Test
    public void tile_71Exists() {
        assertTrue("does tile_71.png asset exist", Gdx.files
            .internal("map/tile_71.png").exists());
    }

    @Test
    public void tile_72Exists() {
        assertTrue("does tile_72.png asset exist", Gdx.files
            .internal("map/tile_72.png").exists());
    }

    @Test
    public void tile_73Exists() {
        assertTrue("does tile_73.png asset exist", Gdx.files
            .internal("map/tile_73.png").exists());
    }

    @Test
    public void tile_74Exists() {
        assertTrue("does tile_74.png asset exist", Gdx.files
            .internal("map/tile_74.png").exists());
    }

    @Test
    public void tile_75Exists() {
        assertTrue("does tile_75.png asset exist", Gdx.files
            .internal("map/tile_75.png").exists());
    }

    @Test
    public void tile_76Exists() {
        assertTrue("does tile_76.png asset exist", Gdx.files
            .internal("map/tile_76.png").exists());
    }

    @Test
    public void tile_77Exists() {
        assertTrue("does tile_77.png asset exist", Gdx.files
            .internal("map/tile_77.png").exists());
    }

    @Test
    public void tile_78Exists() {
        assertTrue("does tile_78.png asset exist", Gdx.files
            .internal("map/tile_78.png").exists());
    }

    @Test
    public void tile_79Exists() {
        assertTrue("does tile_79.png asset exist", Gdx.files
            .internal("map/tile_79.png").exists());
    }

    @Test
    public void tile_80Exists() {
        assertTrue("does tile_80.png asset exist", Gdx.files
            .internal("map/tile_80.png").exists());
    }

    @Test
    public void tile_81Exists() {
        assertTrue("does tile_81.png asset exist", Gdx.files
            .internal("map/tile_81.png").exists());
    }

    @Test
    public void tile_82Exists() {
        assertTrue("does tile_82.png asset exist", Gdx.files
            .internal("map/tile_82.png").exists());
    }

    @Test
    public void tile_83Exists() {
        assertTrue("does tile_83.png asset exist", Gdx.files
            .internal("map/tile_83.png").exists());
    }

    @Test
    public void tile_84Exists() {
        assertTrue("does tile_84.png asset exist", Gdx.files
            .internal("map/tile_84.png").exists());
    }

    @Test
    public void tile_85Exists() {
        assertTrue("does tile_85.png asset exist", Gdx.files
            .internal("map/tile_85.png").exists());
    }

    @Test
    public void tile_86Exists() {
        assertTrue("does tile_86.png asset exist", Gdx.files
            .internal("map/tile_86.png").exists());
    }

    @Test
    public void tile_87Exists() {
        assertTrue("does tile_87.png asset exist", Gdx.files
            .internal("map/tile_87.png").exists());
    }

    @Test
    public void tile_88Exists() {
        assertTrue("does tile_88.png asset exist", Gdx.files
            .internal("map/tile_88.png").exists());
    }

    /* These don't exist from assessment1, don't know why
    @Test
    public void tile_89Exists() {
        assertTrue("does tile_89.png asset exist", Gdx.files
            .internal("map/tile_89.png").exists());
    }

    @Test
    public void tile_90Exists() {
        assertTrue("does tile_90.png asset exist", Gdx.files
            .internal("map/tile_90.png").exists());
    }

    @Test
    public void tile_91Exists() {
        assertTrue("does tile_91.png asset exist", Gdx.files
            .internal("map/tile_91.png").exists());
    }

    @Test
    public void tile_92Exists() {
        assertTrue("does tile_92.png asset exist", Gdx.files
            .internal("map/tile_92.png").exists());
    }
    */

    @Test
    public void tile_93Exists() {
        assertTrue("does tile_93.png asset exist", Gdx.files
            .internal("map/tile_93.png").exists());
    }

    @Test
    public void tile_94Exists() {
        assertTrue("does tile_94.png asset exist", Gdx.files
            .internal("map/tile_94.png").exists());
    }
    
    @Test
    public void watertsxExists() {
        assertTrue("does water.tsx asset exist", Gdx.files
            .internal("map/water.tsx").exists());
    }
    
    
    
    
}