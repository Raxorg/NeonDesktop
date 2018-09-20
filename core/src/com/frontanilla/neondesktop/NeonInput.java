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
    public boolean keyDown(int keycode) {
        handlePlayer1(keycode);
        return true;
    }

    private void handlePlayer1(int keycode) {
        switch (keycode) {
            case Input.Keys.W:
                game.movePlayer(game.getP1(), 0, 1);
                break;
            case Input.Keys.A:
                game.movePlayer(game.getP1(), -1, 0);
                break;
            case Input.Keys.S:
                game.movePlayer(game.getP1(), 0, -1);
                break;
            case Input.Keys.D:
                game.movePlayer(game.getP1(), 1, 0);
                break;
            case Input.Keys.SPACE:
                game.placeBomb(game.getP1());
                break;
            case Input.Keys.UP:
                game.movePlayer(game.getP2(), 0, 1);
                break;
            case Input.Keys.LEFT:
                game.movePlayer(game.getP2(), -1, 0);
                break;
            case Input.Keys.DOWN:
                game.movePlayer(game.getP2(), 0, -1);
                break;
            case Input.Keys.RIGHT:
                game.movePlayer(game.getP2(), 1, 0);
                break;
            case Input.Keys.ENTER:
                game.placeBomb(game.getP2());
                break;
            default:
                break;
        }
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
