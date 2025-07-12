package model.strategy;

import model.Board;
import model.Move;
import model.pieces.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class KingMoveStrategy extends BaseMoveStrategy {
    @Override
    public List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece) {
        List<Move> moves = new ArrayList<>();

        int[] values = {1, 0, -1};
        for (int x : values) {
            for (int y : values) {
                if (x == 0 && y == 0) continue;

                Position newPosition = new Position(currentPosition.getRow() + x, currentPosition.getColumn() + y);

                if (!isValidPosition(newPosition)) continue;

                Piece target = board.getPieceAt(newPosition);
                if (target == null || target.isWhite() != piece.isWhite()) {
                    moves.add(new Move(currentPosition, newPosition, target, false, false));
                }
            }
        }

        return moves;
    }
}
