package model;

import model.strategy.KnightMoveStrategy;

public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite, new KnightMoveStrategy());
    }
}
