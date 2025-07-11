package model.strategy;

import model.Board;
import model.Move;
import model.Piece;
import model.Position;

import java.util.List;

public abstract class BaseMoveStrategy implements MoveStrategy {

    public boolean isValidPosition(Position position) {
        return position.getRow() >= 0 && position.getRow() < 8 && position.getColumn() >= 0 && position.getColumn() < 8;
    }

    public List<Move> addMovesInDirection(Position start, Board board, List<Move> moves,
                                    int rowIncrement, int colIncrement, Piece piece) {
        int row = start.getRow();
        int col = start.getColumn();

        while (true) {
            row += rowIncrement;
            col += colIncrement;
            Position newPosition = new Position(row, col);

            if (!isValidPosition(newPosition)) break;


            Piece target = board.getPieceAt(newPosition);

            if (target == null) {
                moves.add(new Move(start, newPosition, null, false, false));
            }
            else {
                if (target.isWhite() != piece.isWhite()) {
                    moves.add(new Move(start, newPosition, target, false, false));
                }
                break;
            }
        }
        return moves;
    }
}
