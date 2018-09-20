package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Constants {

    // Grid tiles
    public static final float TILE_SIZE = 100f;
    // Grid
    public static final int GRID_ROWS = (int) (Gdx.graphics.getHeight() / TILE_SIZE);
    public static final int GRID_COLUMNS = (int) (Gdx.graphics.getWidth() / TILE_SIZE) - 1;
    public static final float OFFSET_X = (Gdx.graphics.getWidth() - GRID_COLUMNS * Constants.TILE_SIZE) / 2;
    public static final float OFFSET_Y = (Gdx.graphics.getHeight() - GRID_ROWS * Constants.TILE_SIZE) / 2;
    // Times
    public static final float TIME_INTERVAL = 0.2f;
    public static final int MAX_FAKE_TIME = 10;
    // Players
    public static final float PLAYER_SIZE = TILE_SIZE * 0.75f;
    public static final float PLAYER1_X = OFFSET_X - TILE_SIZE / 2;
    public static final float PLAYER2_X = OFFSET_X + GRID_COLUMNS * TILE_SIZE;
    public static final float PLAYER_OFFSET = (TILE_SIZE - PLAYER_SIZE) / 2;
    public static final float INITIAL_PLAYER_Y = OFFSET_Y + PLAYER_OFFSET;
    public static final int INITIAL_PLAYER_ROW = GRID_ROWS - 1;
    // Bombs
    public static final float BOMB_SIZE = TILE_SIZE * 0.75f;
    public static final float BOMB_OFFSET = (TILE_SIZE - BOMB_SIZE) / 2;
    // Rows
    public static final int TOP_ROW = GRID_ROWS - 1;
    public static final int BOTTOM_ROW = 0;
    // Textures
    public static final Texture PLAYER = new Texture("player.png");
    public static final Texture PIXEL = new Texture("pixel.png");
    public static final Texture BOMB = new Texture("bomb.png");
}
