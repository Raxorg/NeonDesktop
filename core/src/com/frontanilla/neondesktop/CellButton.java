package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CellButton extends Button {

    private Player player;
    private Bomb bomb;

    public CellButton(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        player = null;
        bomb = null;
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
        if (bomb != null) {
            bomb.render(batch);
        }
        if (player != null) {
            player.render(batch);
        }
    }

    public Bomb getBomb() {
        return bomb;
    }

    public void setContent(Bomb bomb) {
        this.bomb = bomb;
    }
}
