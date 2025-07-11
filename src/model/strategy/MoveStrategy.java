package model.strategy;

import model.Board;
import model.Move;
import model.Piece;
import model.Position;

import java.util.List;

public interface MoveStrategy {
    List<Move> getLegalMoves(Position currentPosition, Board board, Piece piece);
}
