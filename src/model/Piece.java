package model;

import model.strategy.MoveStrategy;

import java.util.List;

public abstract class Piece {
    private boolean isWhite;
    private MoveStrategy moveStrategy;

    public List<Move> getLegalMoves(Board board, Position from) {
        return moveStrategy.getLegalMoves(from, board, this);
    }

    public Piece(boolean isWhite, MoveStrategy moveStrategy) {
        this.isWhite = isWhite;
        this.moveStrategy = moveStrategy;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public Piece setWhite(boolean isWhite) {
        this.isWhite = isWhite;
        return this;
    }

}
