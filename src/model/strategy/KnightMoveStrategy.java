package model.strategy;

import model.Board;
import model.Move;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class KnightMoveStrategy extends BaseMoveStrategy {

    private static final int[][] OFFSETS = {
            {-2, -1}, {-2,  1},
            {-1, -2}, {-1,  2},
            { 1, -2}, { 1,  2},
            { 2, -1}, { 2,  1}
    };

    @Override
    public List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece) {
        List<Move> moves = new ArrayList<>();

        for (int[] offset : OFFSETS) {
            Position destination = new Position(currentPosition.getRow() + offset[0],
                    currentPosition.getColumn() + offset[1]);
            if (!isValidPosition(destination)) continue;

            Piece target = board.getPieceAt(destination);

            // Empty square → normal move
            // Enemy piece  → capture
            if (target == null || target.isWhite() != piece.isWhite()) {
                moves.add(new Move(currentPosition, destination, target, false, false));
            }
        }
        return moves;
    }
}
