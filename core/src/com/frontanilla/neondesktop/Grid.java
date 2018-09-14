package com.frontanilla.neondesktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Grid {

    private NeonGame game;
    private int rows, columns;
    private CellButton[][] cells;
    private Texture texture, square, circle, triangle;
    private Color color;
    private float time;

    public Grid(NeonGame game, int rows, int columns) {
        this.game = game;
        this.rows = rows;
        this.columns = columns;
        texture = new Texture(Gdx.files.internal("tile.png"));
        generateGrid();
        square = new Texture("square.png");
        circle = new Texture("circle.png");
        triangle = new Texture("triangle.png");
        color = Color.WHITE;
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
                        switch (game.getTurn()) {
                            case 0:
                                cells[finalR][finalC].setContent(new Figure(square, game.getTeam(game.getTurn())));
                                game.passTurn();
                                break;
                            case 1:
                                cells[finalR][finalC].setContent(new Figure(square, game.getTeam(game.getTurn())));
                                game.passTurn();
                                break;
                            case 2:
                                cells[finalR][finalC].setContent(new Figure(square, game.getTeam(game.getTurn())));
                                game.passTurn();
                                break;
                        }
                    }
                };
            }
        }
    }

    public void update(float delta) {
        time += delta;
        if (time >= Constants.BULLET_SPEED) {
            time -= Constants.BULLET_SPEED;
            for (CellButton[] buttonRow : cells) {
                for (CellButton b : buttonRow) {
                    if (b.getFigure().getTexture() == Constants.PIXEL) {

                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (Button[] buttonRow : cells) {
            for (Button b : buttonRow) {
                b.setColor(color);
                b.render(batch);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}