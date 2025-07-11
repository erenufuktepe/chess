package model;

public class Move {
    private final Position from;
    private final Position to;
    private final Piece capturedPiece;
    private final boolean isPromotion;
    private final boolean isEnPassant;

    public Move(Position from, Position to, Piece capturedPiece, boolean isPromotion, boolean isEnPassant) {
        this.capturedPiece = capturedPiece;
        this.from = from;
        this.to = to;
        this.isPromotion = isPromotion;
        this.isEnPassant = isEnPassant;
    }

    public Position getFrom() {
        return this.from;
    }

    public Position getTo() {
        return this.to;
    }

    public Piece getCapturedPiece() {
        return this.capturedPiece;
    }

    public boolean isPromotion() {
        return this.isPromotion;
    }

    public boolean isEnPassant() {
        return this.isEnPassant;
    }

}
