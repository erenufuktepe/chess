package model.pieces;

import model.Board;
import model.Move;
import model.Position;
import model.strategy.MoveStrategy;

import java.util.List;

public abstract class Piece {
    private boolean isWhite;
    private boolean hasMoved;
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

    public boolean hasMoved() {
        return this.hasMoved;
    }

    public Piece setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
        return this;
    }

}
