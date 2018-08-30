package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class Input extends InputAdapter {

    private NeonGame game;

    public Input(NeonGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;
        for (Button[] buttonRows : game.getGrid().getCells()) {
            for (Button b : buttonRows) {
                if (b.isInside(screenX, screenY)) {
                    b.onTouch();
                    return true;
                }
            }
        }
        return false;
    }
}
