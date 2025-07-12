package model.strategy;

import model.Board;
import model.Move;
import model.pieces.Piece;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class PawnMoveStrategy extends BaseMoveStrategy {

    @Override
    public List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece) {
        List<Move> moves = new ArrayList<>();

        int direction = piece.isWhite() ? -1 : 1;
        int startRow = piece.isWhite() ? 6 : 1;
        int finalRow = piece.isWhite() ? 0 : 7;

        Position oneStep = new Position(currentPosition.getRow() + direction, currentPosition.getColumn());
        if (isValidPosition(oneStep) && board.isEmpty(oneStep)) {
            boolean isPromotion = oneStep.getRow() == finalRow;
            moves.add(new Move(currentPosition, oneStep, null, isPromotion, false));

            Position twoSteps = new Position(currentPosition.getRow() + 2 * direction, currentPosition.getColumn());
            if (currentPosition.getRow() == startRow && board.isEmpty(twoSteps)) {
                moves.add(new Move(currentPosition, twoSteps, null, false, false));
            }
        }

        int[] captureOffsets = { -1, 1 };
        for (int offset : captureOffsets) {
            Position diagonalPosition = new Position(currentPosition.getRow() + direction, currentPosition.getColumn() + offset);
            if (isValidPosition(diagonalPosition)) {
                Piece target = board.getPieceAt(diagonalPosition);
                if (target != null && target.isWhite() != piece.isWhite()) {
                    boolean isPromotion = diagonalPosition.getRow() == finalRow;
                    moves.add(new Move(currentPosition, diagonalPosition, target, isPromotion, false));
                }
            }
        }

        return moves;
    }
}
