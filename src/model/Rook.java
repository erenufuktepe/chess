package model;

import model.strategy.RookMoveStrategy;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite, new RookMoveStrategy());
    }
}
