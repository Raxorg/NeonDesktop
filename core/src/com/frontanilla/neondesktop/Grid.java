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
            for (int row = 0; row < cells.length; row++) {
                // Check player 1
                for (int column = cells[row].length - 1; column >= 0; column--) {
                    if (cells[row][column].getFigure() != null && cells[row][column].getFigure().getTexture() == Constants.PIXEL) {
                        if (!cells[row][column].getFigure().hasMoved()) {
                            if (column != cells[row].length - 1 &&
                                    cells[row][column].getFigure().getTeam().getTeamID() == 0) {
                                cells[row][column].getFigure().setMoved(true);
                                if (cells[row][column + 1].getFigure() != null
                                        && cells[row][column + 1].getFigure().getTeam().getTeamID() == 1) {
                                    cells[row][column + 1].setContent(null);
                                } else if (column != cells[row].length - 2
                                        && cells[row][column + 2].getFigure() != null
                                        && cells[row][column + 2].getFigure().getTeam().getTeamID() == 1) {
                                    cells[row][column + 2].setContent(null);
                                } else {
                                    cells[row][column + 1].setContent(cells[row][column].getFigure());
                                }
                                cells[row][column].setContent(null);
                            }
                        }
                    }
                }
                // Check player 2
                for (int column = 0; column < cells[row].length; column++) {
                    if (cells[row][column].getFigure() != null && cells[row][column].getFigure().getTexture() == Constants.PIXEL) {
                        if (!cells[row][column].getFigure().hasMoved()) {
                            if (column != 0 && cells[row][column].getFigure().getTeam().getTeamID() == 1) {
                                cells[row][column].getFigure().setMoved(true);
                                cells[row][column - 1].setContent(cells[row][column].getFigure());
                                cells[row][column].setContent(null);
                            }
                        }
                    }
                }
            }
            for (int row = 0; row < cells.length; row++) {
                for (int column = cells[row].length - 1; column > 0; column--) {
                    if (cells[row][column].getFigure() != null && cells[row][column].getFigure().getTexture() == Constants.PIXEL) {
                        cells[row][column].getFigure().setMoved(false);
                    }
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (CellButton[] buttonRow : cells) {
            for (CellButton b : buttonRow) {
                b.setColor(color);
                b.render(batch);
            }
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }
}