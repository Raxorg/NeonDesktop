package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;

public class Constants {

    // Grid tiles
    public static final float TILE_SIZE = 100f;
    // Grid
    public static final int GRID_ROWS = (int) (Gdx.graphics.getHeight() / TILE_SIZE);
    public static final int GRID_COLUMNS = (int) (Gdx.graphics.getWidth() / TILE_SIZE) - 1;
    public static final float OFFSET_X = (Gdx.graphics.getWidth() - GRID_COLUMNS * Constants.TILE_SIZE) / 2;
    public static final float OFFSET_Y = (Gdx.graphics.getHeight() - GRID_ROWS * Constants.TILE_SIZE) / 2;
    // Figures
    public static final float FIGURE_SIZE = TILE_SIZE / 2;
    public static final float FIGURE_OFFSET = FIGURE_SIZE / 2;
    // Times
    public static final float TIME_INTERVAL = 3f;
    public static final int MAX_FAKE_TIME = 10;
    // Players
    public static final float PLAYER_SIZE = TILE_SIZE / 2;
    public static final float PLAYER1_X = OFFSET_X - TILE_SIZE / 2;
    public static final float PLAYER2_X = OFFSET_X + GRID_COLUMNS * TILE_SIZE;
    public static final float INITIAL_PLAYER_Y = OFFSET_Y + PLAYER_SIZE / 2;
    public static final int INITIAL_PLAYER_ROW = GRID_ROWS - 1;
    // Rows
    public static final int TOP_ROW = GRID_ROWS - 1;
    public static final int BOTTOM_ROW = 0;
}
