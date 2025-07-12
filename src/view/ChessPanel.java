package view;

import controller.ChessController;
import model.Move;
import model.pieces.Piece;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ChessPanel extends JPanel {
    private final Square[][] squares;
    private ChessController controller;
    private Square activeSquare;

    public ChessPanel() {
        this.squares = new Square[8][8];
        this.controller = new ChessController();
        setLayout(null);
        addSquares();
    }

    private void addSquares() {
        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                Color color = (x + y) % 2 == 0  ? Color.WHITE : Color.DARK_GRAY;
                squares[x][y] = new Square(x, y, color);

                if(controller.getBoard().getPieces()[x][y] != null) {
                    squares[x][y].drawIcon(controller.getBoard().getPieces()[x][y].isWhite(), controller.getBoard().getPieces()[x][y].getClass().getSimpleName());
                }
                squares[x][y].addActionListener(onSquareClick());
                add(squares[x][y]);
            }
        }
    }

    public ActionListener onSquareClick() throws RuntimeException {
        return event -> {
            Square squareClicked = (Square) event.getSource();

            if(!squareClicked.isMoveAction() && squareClicked.hasPiece()) {
                if(controller.getState().canPlay(new Position(squareClicked.getRow(), squareClicked.getColumn()), controller)){
                    resetSquares();
                    return;
                }
            }

            if(squareClicked.isMoveAction()) {
                Position from = new Position(getActiveSquare().getRow(), getActiveSquare().getColumn());
                Position to = new Position(squareClicked.getRow(), squareClicked.getColumn());
                movePiece(from, to);
                controller.changeTurn();
                return;
            }

            resetSquares();

            Position from = new Position(squareClicked.getRow(), squareClicked.getColumn());
            Piece piece = controller.getBoard().getPieceAt(from);

            if(piece == null) {
                return;
            }

            setActiveSquare(squareClicked);
            List<Move> moveList = piece.getLegalMoves(controller.getBoard(), from);
            moveList.stream().forEach(move -> getSquares()[move.getTo().getRow()][move.getTo().getColumn()].setMovable(true));
        };
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
        controller.getBoard().movePiece(from, to);
        resetSquares();
    }

    public Square[][] getSquares() {
        return this.squares;
    }

}
