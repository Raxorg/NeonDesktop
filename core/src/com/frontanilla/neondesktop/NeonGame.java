package com.frontanilla.neondesktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class NeonGame extends Game {
    private SpriteBatch batch;
    private Texture pixel;
    private float time;
    private Grid grid;
    private int turn;
    private Team[] teams;
    private Player p1, p2;
    private BitmapFont font;

    @Override
    public void create() {
        batch = new SpriteBatch();
        pixel = new Texture("pixel.png");
        time = 0;
        grid = new Grid(this, Constants.GRID_ROWS, Constants.GRID_COLUMNS);
        generateTeams();
        generatePlayers();
        Gdx.input.setInputProcessor(new NeonInput(this));
        font = new BitmapFont();
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
        p1.render(batch);
        p2.render(batch);
        drawText();
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

    public int getTurn() {
        return turn;
    }

    private void drawText() {
        float currentTime = Constants.TIME_INTERVAL - time;
        int fakeTime = (int) (currentTime * (Constants.MAX_FAKE_TIME / Constants.TIME_INTERVAL)) + 1;
        String text = fakeTime + "";
        font.draw(batch,
                text,
                Gdx.graphics.getWidth() / 2 - Utils.getTextSize(text, font).x / 2,
                Gdx.graphics.getHeight() / 2);
    }

    public void passTurn() {
        turn++;
        if (turn > teams.length - 1) {
            turn = 0;
        }
    }

    public void changeColors() {
        for (Team team : teams) {
            team.setColor(Utils.randomColor());
        }
    }

    private void changeGridColor() {
        grid.setColor(Utils.randomColor());
    }

    private void generateTeams() {
        teams = new Team[2];
        teams[0] = new Team(0, Utils.randomColor());
        teams[1] = new Team(1, Utils.randomColor());
        grid.setColor(Utils.randomColor());
    }

    private void generatePlayers() {
        p1 = new Player(teams[0]);
        p2 = new Player(teams[1]);
    }

    public Team getTeam(int teamID) {
        return teams[teamID];
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }
}