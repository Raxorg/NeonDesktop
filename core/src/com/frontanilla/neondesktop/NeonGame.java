package com.frontanilla.neondesktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class NeonGame extends Game {
    private SpriteBatch batch;
    private Texture pixel;
    private Random random;
    private float time;
    private Grid grid;
    private boolean turn;
    private Color c1, c2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        pixel = new Texture("pixel.png");
        random = new Random();
        time = 0;
        grid = new Grid(this, Constants.GRID_ROWS, Constants.GRID_COLUMNS);
        generateColors();

        Gdx.input.setInputProcessor(new Input(this));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        time += Gdx.graphics.getDeltaTime();
        if (time >= Constants.TIME_INTERVAL) {
            generateColors();
            time = 0;
        }

        batch.begin();
        grid.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        // grid.dispose();
        pixel.dispose();
    }

    public Grid getGrid() {
        return grid;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    private void generateColors() {
        c1 = new Color(random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                1);
        c2 = new Color(random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                1);
        Color gridColor = new Color(random.nextFloat(),
                random.nextFloat(),
                random.nextFloat(),
                1);
        // TODO USE THIS METHOD
    }

    public Color getColor1() {
        return c1;
    }

    public Color getColor2() {
        return c2;
    }
}