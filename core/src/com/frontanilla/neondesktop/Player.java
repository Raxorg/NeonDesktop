package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    private Texture texture;
    private Team team;

    public Player(Team team) {
        this.team = team;
        texture = team.getTeamID() == 0 ? new Texture("player1.png") : new Texture("player2.png");
    }

    public Texture getTexture() {
        return texture;
    }

    public Team getTeam() {
        return team;
    }

    public void render(SpriteBatch batch) {
        batch.setColor(team.getColor());
        if (team.getTeamID() == 0) {
            batch.draw(texture,
                    Constants.PLAYER1_X,
                    Constants.INITIAL_PLAYER_Y,
                    Constants.PLAYER1_SIZE,
                    Constants.PLAYER1_SIZE);
        } else {
            batch.draw(texture,
                    Constants.PLAYER2_X,
                    Constants.INITIAL_PLAYER_Y,
                    Constants.PLAYER1_SIZE,
                    Constants.PLAYER1_SIZE);
        }
    }
}
