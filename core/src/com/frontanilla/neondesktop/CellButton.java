package com.frontanilla.neondesktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class CellButton extends Button {

    private Figure figure;

    public CellButton(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
    }

    @Override
    public void render(SpriteBatch batch) {
        super.render(batch);
        if (figure != null) {
            batch.setColor(figure.getTeam().getColor());
            batch.draw(
                    figure.getTexture(),
                    bounds.x + Constants.FIGURE_OFFSET,
                    bounds.y + Constants.FIGURE_OFFSET,
                    Constants.FIGURE_SIZE,
                    Constants.FIGURE_SIZE);
        }
    }

    public Figure getFigure() {
        return figure;
    }

    public void setContent(Figure figure) {
        this.figure = figure;
    }
}
