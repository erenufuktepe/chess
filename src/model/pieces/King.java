package model.pieces;

import model.strategy.KingMoveStrategy;

public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite, new KingMoveStrategy());
    }
}
