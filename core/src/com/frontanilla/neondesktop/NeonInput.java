package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class NeonInput extends InputAdapter {

    private NeonGame game;

    public NeonInput(NeonGame game) {
        this.game = game;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenY = Gdx.graphics.getHeight() - screenY;
        switch (button) {
            case Input.Buttons.LEFT:
                return handleLeftClick(screenX, screenY);
            case Input.Buttons.RIGHT:
                return handleRightClick();
            default:
                return false;
        }
    }

    private boolean handleLeftClick(int screenX, int screenY) {
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

    private boolean handleRightClick() {
        game.changeColors();
        return true;
    }
}
