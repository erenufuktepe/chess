package model;

import model.enums.PieceType;
import model.factory.PieceFactory;
import model.pieces.*;

import java.io.InvalidObjectException;

public class Board {
    private final Piece[][] pieces;

    public Board() {
        this.pieces = new Piece[8][8];
        setupPieces();
    }

    private void setupPieces() {
        try {
            // Place white pieces
            setPieceAt(new Position(7, 0), PieceFactory.createPiece(PieceType.ROOK, true));
            setPieceAt(new Position(7, 1), PieceFactory.createPiece(PieceType.KNIGHT, true));
            setPieceAt(new Position(7, 2), PieceFactory.createPiece(PieceType.BISHOP, true));
            setPieceAt(new Position(7, 3), PieceFactory.createPiece(PieceType.QUEEN, true));
            setPieceAt(new Position(7, 4), PieceFactory.createPiece(PieceType.KING, true));
            setPieceAt(new Position(7, 5), PieceFactory.createPiece(PieceType.BISHOP, true));
            setPieceAt(new Position(7, 6), PieceFactory.createPiece(PieceType.KNIGHT, true));
            setPieceAt(new Position(7, 7), PieceFactory.createPiece(PieceType.ROOK, true));

            for (int col = 0; col < 8; col++) {
                setPieceAt(new Position(6, col), PieceFactory.createPiece(PieceType.PAWN, true));
            }

            // Place black pieces
            setPieceAt(new Position(0, 0), PieceFactory.createPiece(PieceType.ROOK, false));
            setPieceAt(new Position(0, 1), PieceFactory.createPiece(PieceType.KNIGHT, false));
            setPieceAt(new Position(0, 2), PieceFactory.createPiece(PieceType.BISHOP, false));
            setPieceAt(new Position(0, 3), PieceFactory.createPiece(PieceType.QUEEN, false));
            setPieceAt(new Position(0, 4), PieceFactory.createPiece(PieceType.KING, false));
            setPieceAt(new Position(0, 5), PieceFactory.createPiece(PieceType.BISHOP, false));
            setPieceAt(new Position(0, 6), PieceFactory.createPiece(PieceType.KNIGHT, false));
            setPieceAt(new Position(0, 7), PieceFactory.createPiece(PieceType.ROOK, false));

            for (int col = 0; col < 8; col++) {
                setPieceAt(new Position(1, col), PieceFactory.createPiece(PieceType.PAWN, false));
            }
        }
        catch(InvalidObjectException exception) {
            throw new RuntimeException();
        }

    }

    public Piece[][] getPieces() {
        return this.pieces;
    }

    public Piece getPieceAt(Position pos) {
        return pieces[pos.getRow()][pos.getColumn()];
    }

    public Board setPieceAt(Position position, Piece piece) {
        pieces[position.getRow()][position.getColumn()] = piece;
        return this;
    }

    public boolean movePiece(Position from, Position to) {
        pieces[to.getRow()][to.getColumn()] = pieces[from.getRow()][from.getColumn()];
        pieces[from.getRow()][from.getColumn()] = null;
        return true;
    }

    public boolean isEmpty(Position position) {
        return pieces[position.getRow()][position.getColumn()] == null ? true : false;
    }

}
