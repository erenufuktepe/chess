package view;

import controller.ChessController;
import model.Board;
import model.Position;

import javax.swing.*;
import java.awt.*;

public class ChessPanel extends JPanel {
    private final Board board;
    private final Square[][] squares;
    private ChessController controller;
    private Square activeSquare;

    public ChessPanel() {
        this.board = new Board();
        this.squares = new Square[8][8];
        this.controller = new ChessController(this);
        setLayout(null);
        addSquares();
        //addMouseListener(controller);
    }

    private void addSquares() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                Color color = (x + y) % 2 == 0  ? Color.WHITE : Color.DARK_GRAY;
                squares[x][y] = new Square(x, y, color);

                if(board.getBoard()[x][y] != null) {
                    squares[x][y].drawIcon(board.getBoard()[x][y].isWhite(), board.getBoard()[x][y].getClass().getSimpleName());
                }

                squares[x][y].addActionListener(controller.pieceOnClick());
                add(squares[x][y]);
            }
        }
    }

    public void resetSquares() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                this.squares[x][y].setMovable(false);
            }
        }
    }

    public Square getActiveSquare() {
        return this.activeSquare;
    }

    public void setActiveSquare(Square square) {
        this.activeSquare = square;
    }

    public void movePiece(Position from, Position to) {
        squares[from.getRow()][from.getColumn()].moveIcon(squares[to.getRow()][to.getColumn()]);
        board.movePiece(from, to);
        resetSquares();
    }

    public Square[][] getSquares() {
        return this.squares;
    }

    public Board getBoard() {
        return this.board;
    }

}
