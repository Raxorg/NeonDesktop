package com.frontanilla.neondesktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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
    private Team t1, t2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        pixel = new Texture("pixel.png");
        random = new Random();
        time = 0;
        grid = new Grid(this, Constants.GRID_ROWS, Constants.GRID_COLUMNS);
        generateTeams();
        // VANIA SOBRE UN JUEGO EL LUNES
        // YO EXPONGO LIBRO - THE ULTIMATE GUIDE TO VIDEOGAME WRITING DESIGN 02
        Gdx.input.setInputProcessor(new NeonInput(this));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        time += Gdx.graphics.getDeltaTime();
        if (time >= Constants.TIME_INTERVAL) {
            changeGridColor();
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

    public void changeColors() {
        t1.setColor(Utils.randomColor());
        t2.setColor(Utils.randomColor());
    }

    private void changeGridColor() {
        grid.setColor(Utils.randomColor());
    }

    private void generateTeams() {
        t1 = new Team(Utils.randomColor());
        t2 = new Team(Utils.randomColor());
        grid.setColor(Utils.randomColor());
    }

    public Team getTeam1() {
        return t1;
    }

    public Team getTeam2() {
        return t2;
    }
}