package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

    private int row;
    private Texture texture;
    private Team team;

    public Player(Team team) {
        this.team = team;
        texture = team.getTeamID() == 0 ? new Texture("player1.png") : new Texture("player2.png");
        row = Constants.INITIAL_PLAYER_ROW;
    }

    public Team getTeam() {
        return team;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(team.getColor());
        if (team.getTeamID() == 0) {
            batch.draw(texture,
                    Constants.PLAYER1_X,
                    Constants.INITIAL_PLAYER_Y + row * Constants.TILE_SIZE,
                    Constants.PLAYER_SIZE,
                    Constants.PLAYER_SIZE);
        } else {
            batch.draw(texture,
                    Constants.PLAYER2_X,
                    Constants.INITIAL_PLAYER_Y + row * Constants.TILE_SIZE,
                    Constants.PLAYER_SIZE,
                    Constants.PLAYER_SIZE);
        }
    }

    public void move(boolean up) {
        if (up) {
            row++;
            if (row > Constants.TOP_ROW) {
                row--;
            }
        } else {
            row--;
            if (row < Constants.BOTTOM_ROW) {
                row++;
            }
        }
    }

    public void shoot() {
        if (team.getTeamID() == 0) {
            
        } else {

        }
    }
}
