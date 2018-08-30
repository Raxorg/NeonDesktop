package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CellButton extends Button {

    private Texture content;

    public CellButton(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
        if (content != null) {
            batch.setColor(color);
            batch.draw(
                    content,
                    bounds.x + Constants.FIGURE_OFFSET,
                    bounds.y + Constants.FIGURE_OFFSET,
                    Constants.FIGURE_SIZE,
                    Constants.FIGURE_SIZE);
        }
    }

    public void setContent(Texture content) {
        this.content = content;
    }
}
