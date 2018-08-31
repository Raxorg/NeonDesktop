package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Color;

public class Team {
    private Color color;

    public Team(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
