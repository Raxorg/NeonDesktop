package com.frontanilla.neondesktop;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class Button {

    private Texture texture;
    protected Rectangle bounds;
    protected Color color;

    public Button(Texture texture, float x, float y, float width, float height) {
        this.texture = texture;
        bounds = new Rectangle(x, y, width, height);
        color = Color.WHITE;
    }

    public boolean isInside(float x, float y) {
        return bounds.contains(x, y);
    }

    public void render(SpriteBatch batch) {
        batch.setColor(color);
        batch.draw(texture,
                bounds.x,
                bounds.y,
                bounds.width,
                bounds.height);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void onTouch();
}
