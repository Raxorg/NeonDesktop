package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Color;

public class Team {
    private int teamID;
    private Color color;

    public Team(int teamID, Color color) {
        this.teamID = teamID;
        this.color = color;
    }

    public int getTeamID() {
        return teamID;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
