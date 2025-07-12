package model.pieces;

import model.strategy.PawnMoveStrategy;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite, new PawnMoveStrategy());
    }

}
