package model;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        setWhite(isWhite);
    }
    @Override
    public List<Move> getMoves(Board board, Position from) {
        try{
            List<Move> moveList = new ArrayList<>();

            for(int index = 1; index < 8; index++) {
                if(from.getRow() + index < 8 && from.getColumn() + index < 8) {
                    Position to = new Position(from.getRow() + index, from.getColumn() + index);
                    Move moveRightBottom = new Move(this, from, to);
                    moveRightBottom.setCapturedPiece(board.getPieceAt(to));
                    moveList.add(moveRightBottom);

                    if (board.getPieceAt(to) != null) {
                        break;
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
