package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;

public class Figure {
    private Texture texture;
    private Team team;

    public Figure(Texture texture, Team team) {
        this.texture = texture;
        this.team = team;
    }

    public Texture getTexture() {
        return texture;
    }

    public Team getTeam() {
        return team;
    }
}
