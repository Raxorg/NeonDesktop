package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;

public class Constants {

    public static final float TILE_SIZE = 100f;
    public static final int GRID_ROWS = (int) (Gdx.graphics.getHeight() / TILE_SIZE);
    public static final int GRID_COLUMNS = (int) (Gdx.graphics.getWidth() / TILE_SIZE);
    public static final float OFFSET_X = (Gdx.graphics.getWidth() - GRID_COLUMNS * Constants.TILE_SIZE) / 2;
    public static final float OFFSET_Y = (Gdx.graphics.getHeight() - GRID_ROWS * Constants.TILE_SIZE) / 2;
    public static final float FIGURE_SIZE = 50f;
    public static final int FIGURE_OFFSET = 25;
    public static final float TIME_INTERVAL = 0.5f;
}
