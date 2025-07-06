package model;

import java.util.List;

public abstract class Piece {
    private boolean isWhite;
    private boolean isFirstMove;

    public List<Move> getMoves(Board board, Position from) {
        throw new UnsupportedOperationException();
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public Piece setWhite(boolean isWhite) {
        this.isWhite = isWhite;
        return this;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public Piece setIsFirstMove(boolean isFirstMove) {
        this.isFirstMove = isFirstMove;
        return this;
    }
}
