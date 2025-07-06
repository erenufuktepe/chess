package model;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        setWhite(isWhite);
        setIsFirstMove(true);
    }

    @Override
    public List<Move> getMoves(Board board, Position from) {
        try{
            List<Move> moveList = new ArrayList<>();
            int strategy = isWhite() ? -1 : 1;
            // First move
            if(isFirstMove()) {
                Position to = new Position(from.getRow() + (2 * strategy), from.getColumn());
                Move moveTwoRows = new Move(this, from, to);
                moveTwoRows.setCapturedPiece(board.getPieceAt(to));
                moveList.add(moveTwoRows);
            }

            // Normal move
            if(from.getRow() + (strategy * 1) > -1 &&  from.getRow() + (strategy * 1) < 8) {
                Position to =  new Position(from.getRow() + (strategy * 1), from.getColumn());
                Move moveOneRow = new Move(this, from, to);
                moveList.add(moveOneRow);
            }

            // Right diagonal capture
            if(from.getRow() + (strategy * 1) > -1
                    && from.getRow() + (strategy * 1) < 8
                    && from.getColumn() + (strategy * 1) > -1
                    && from.getColumn() + (strategy * 1) < 8) {
                Position to = new Position(from.getRow() + (strategy * 1), from.getColumn() + (strategy * 1));

                Piece captured = board.getPieceAt(to);
                if(captured != null) {
                    if (board.getPieceAt(to).isWhite() != isWhite()) {
                        Move moveRightCapture = new Move(this, from, to);
                        moveRightCapture.setCapturedPiece(captured);
                        moveList.add(moveRightCapture);
                    }
                }
            }

            // Left diagonal capture
            if(from.getRow() + (strategy * 1) < 8 && from.getColumn() - (strategy * 1) > -1
                    && from.getRow() + (strategy * 1) < 8 && from.getColumn() - (strategy * 1) < 8
                    && from.getColumn() + (strategy * 1) < 8 && from.getColumn() - (strategy * 1) > -1
                    && from.getColumn() + (strategy * 1) < 8 && from.getColumn() - (strategy * 1) < 8) {
                Position to = new Position(from.getRow() + (strategy * 1), from.getColumn() - (strategy * 1));
                Piece captured = board.getPieceAt(to);
                if(captured != null) {
                    if (board.getPieceAt(to).isWhite() != isWhite()){
                        Move moveRightCapture = new Move(this, from, to);
                        moveRightCapture.setCapturedPiece(captured);
                        moveList.add(moveRightCapture);
                    }
                }
            }

            return moveList;
        }
        catch (UnsupportedOperationException exception) {
            throw new UnsupportedOperationException(exception);
        }
    }
}
