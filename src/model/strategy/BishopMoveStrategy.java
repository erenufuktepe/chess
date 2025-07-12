package model.strategy;

import model.Board;
import model.Move;
import model.pieces.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class BishopMoveStrategy extends BaseMoveStrategy {

    private static final int[][] OFFSETS = {
            {1, 1},
            {1, -1},
            {-1, -1},
            {-1, 1}
    };

    @Override
    public List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece) {
        List<Move> moves = new ArrayList<>();

        for (int[] offset : OFFSETS) {
            addMovesInDirection(currentPosition, board, moves, offset[0], offset[1], piece);
        }

        return moves;
    }
}
