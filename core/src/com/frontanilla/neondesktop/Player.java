package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private Team team;
    private CellButton cellButton;
    private Texture texture;
    private int maxBombs;

    public Player(Team team, CellButton cellButton) {
        this.team = team;
        this.cellButton = cellButton;
        texture = Constants.PLAYER;
        maxBombs = 1;
    }

    public void setCellButton(CellButton cellButton) {
        this.cellButton = cellButton;
    }

    public int getMaxBombs() {
        return maxBombs;
    }

    public void setMaxBombs(int maxBombs) {
        this.maxBombs = maxBombs;
    }

    public Team getTeam() {
        return team;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(team.getColor());
        batch.draw(texture,
                cellButton.bounds.x,
                cellButton.bounds.y,
                Constants.PLAYER_SIZE,
                Constants.PLAYER_SIZE);
    }

    public Texture getTexture() {
        return texture;
    }

    public void placeBomb() {
        cellButton.setContent(new Bomb(team, cellButton));
    }
}
