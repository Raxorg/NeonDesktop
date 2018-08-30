package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Grid {

    private NeonGame game;
    private int rows, columns;
    private CellButton[][] cells;
    private Texture texture, square, circle;

    public Grid(NeonGame game, int rows, int columns) {
        this.game = game;
        this.rows = rows;
        this.columns = columns;
        texture = new Texture(Gdx.files.internal("tile.png"));
        generateGrid();
        square = new Texture("square.png");
        circle = new Texture("circle.png");
    }

    public CellButton[][] getCells() {
        return cells;
    }

    private void generateGrid() {
        cells = new CellButton[rows][columns];
        for (int r = 0; r < cells.length; r++) {
            cells[r] = new CellButton[columns];
            for (int c = 0; c < cells[r].length; c++) {
                final int finalC = c;
                final int finalR = r;
                cells[r][c] = new CellButton(
                        texture,
                        finalC * Constants.TILE_SIZE + Constants.OFFSET_X,
                        finalR * Constants.TILE_SIZE + Constants.OFFSET_Y,
                        Constants.TILE_SIZE,
                        Constants.TILE_SIZE
                ) {
                    @Override
                    public void onTouch() {
                        if (game.getTurn()) {
                            cells[finalR][finalC].setContent(square);
                            cells[finalR][finalC].setColor(game.getColor1());
                            game.setTurn(!game.getTurn());
                        } else {
                            cells[finalR][finalC].setContent(circle);
                            cells[finalR][finalC].setColor(game.getColor2());
                            game.setTurn(!game.getTurn());
                        }
                    }
                };
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Button[] buttonRow : cells) {
            for (Button b : buttonRow) {
                b.render(batch);
            }
        }
    }
}