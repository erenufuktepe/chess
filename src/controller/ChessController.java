package controller;

import model.Move;
import model.Piece;
import model.Position;
import view.ChessPanel;
import view.Square;

import java.awt.event.ActionListener;
import java.util.List;

public class ChessController {
    public ChessPanel chessPanel;
    public boolean isWhiteTurn;

    public ChessController(ChessPanel chessPanel) {
        this.isWhiteTurn = true;
        this.chessPanel = chessPanel;
    }

    private boolean isWhiteTurn() {
        return this.isWhiteTurn;
    }

    private void changeTurn() {
        this.isWhiteTurn = !isWhiteTurn;
    }

    public ActionListener pieceOnClick() throws RuntimeException {
        return event -> {
            Square squareClicked = (Square) event.getSource();

            if(!squareClicked.isMoveAction() && squareClicked.hasPiece()) {
                if(isWhiteTurn != chessPanel.getBoard().getBoard()[squareClicked.getRow()][squareClicked.getColumn()].isWhite()){
                    chessPanel.resetSquares();
                    return;
                }
            }

            if(squareClicked.isMoveAction()) {
                Position from = new Position(chessPanel.getActiveSquare().getRow(), chessPanel.getActiveSquare().getColumn());
                Position to = new Position(squareClicked.getRow(), squareClicked.getColumn());
                chessPanel.movePiece(from, to);
                changeTurn();
                return;
            }

            chessPanel.resetSquares();

            Position from = new Position(squareClicked.getRow(), squareClicked.getColumn());
            Piece piece = chessPanel.getBoard().getPieceAt(from);

            if(piece == null) {
                return;
            }

            chessPanel.setActiveSquare(squareClicked);
            List<Move> moveList = piece.getLegalMoves(chessPanel.getBoard(), from);
            moveList.stream().forEach(move -> chessPanel.getSquares()[move.getTo().getRow()][move.getTo().getColumn()].setMovable(true));
        };
    }

}
