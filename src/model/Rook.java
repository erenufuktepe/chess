package model;

import model.strategy.PawnMoveStrategy;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite, new PawnMoveStrategy());
    }
}
