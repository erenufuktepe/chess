package model;

import model.strategy.QueenMoveStrategy;

public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite, new QueenMoveStrategy());    }
}
