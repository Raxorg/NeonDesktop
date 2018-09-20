package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bomb {

    private Team team;
    private CellButton cellButton;

    public Bomb(Team team, CellButton cellButton) {
        this.team = team;
        this.cellButton = cellButton;
    }

    public void explode() {
        System.out.println("EXPLOSION");
    }

    public void render(SpriteBatch batch) {
        batch.setColor(team.getColor());
        batch.draw(
                Constants.BOMB,
                cellButton.bounds.x + Constants.BOMB_OFFSET,
                cellButton.bounds.y + Constants.BOMB_OFFSET,
                Constants.BOMB_SIZE,
                Constants.BOMB_SIZE);
    }

    public Team getTeam() {
        return team;
    }

    public CellButton getCellButton() {
        return cellButton;
    }
}
