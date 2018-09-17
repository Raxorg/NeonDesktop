package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;

public class Figure {
    private Texture texture;
    private Team team;
    private boolean moved;

    public Figure(Texture texture, Team team) {
        this.texture = texture;
        this.team = team;
        moved = false;
    }

    public Texture getTexture() {
        return texture;
    }

    public Team getTeam() {
        return team;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean hasMoved() {
        return moved;
    }
}
