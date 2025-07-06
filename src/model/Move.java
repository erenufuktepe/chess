package model;

public class Move {
    private Position from;
    private Position to;
    private Piece movedPiece;
    private Piece capturedPiece;

    public Move(Piece movedPiece, Position from, Position to) {
        this.movedPiece = movedPiece;
        this.from = from;
        this.to = to;
    }

    public Position getFrom() {
        return this.from;
    }

    public Move setFrom(Position from) {
        this.from = from;
        return this;
    }

    public Position getTo() {
        return this.to;
    }

    public Move setTo(Position to) {
        this.to = to;
        return this;
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }

    public Move setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
        return this;
    }

    public Piece getCapturedPiece() {
        return this.capturedPiece;
    }

    public Move setCapturedPiece(Piece capturedPiece) {
        this.capturedPiece = capturedPiece;
        return this;
    }
}
