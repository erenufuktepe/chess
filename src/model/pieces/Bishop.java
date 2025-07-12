package model.pieces;


import model.strategy.BishopMoveStrategy;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite, new BishopMoveStrategy());
    }

}
