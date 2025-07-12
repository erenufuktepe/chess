package model.state;

import controller.ChessController;
import model.Position;
import model.pieces.Piece;

public class BlackTurnState implements GameState {
    @Override
    public boolean canPlay(Position position, ChessController controller) {
        Piece piece = controller.getBoard().getPieceAt(position);
        if (piece != null && piece.isWhite()) {
            return true;
        }
        return false;
    }
}
