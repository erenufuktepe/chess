package model.strategy;

import model.Board;
import model.Move;
import model.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class BishopMoveStrategy extends BaseMoveStrategy {

    @Override
    public List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece) {
        List<Move> moves = new ArrayList<>();

        int[][] directions = {
                {1, 1},
                {1, -1},
                {-1, -1},
                {-1, 1}
        };

        for (int[] dir : directions) {
            addMovesInDirection(currentPosition, board, moves, dir[0], dir[1], piece);
        }

        return moves;
    }
}
