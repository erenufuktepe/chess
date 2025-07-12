package model.factory;

import model.enums.PieceType;
import model.pieces.*;

import java.io.InvalidObjectException;

public class PieceFactory {

    public static Piece createPiece(PieceType pieceType, boolean isWhite) throws InvalidObjectException {
        return switch (pieceType) {
            case KING -> new King(isWhite);
            case BISHOP -> new Bishop(isWhite);
            case KNIGHT -> new Knight(isWhite);
            case PAWN -> new Pawn(isWhite);
            case QUEEN -> new Queen(isWhite);
            case ROOK -> new Rook(isWhite);
            default -> throw new InvalidObjectException("Invalid Piece Type!");
        };
    }

}
