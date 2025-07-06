package model;

public class Board {
    private final Piece[][] board;
    private boolean isWhiteTurn;

    public Board() {
        this.board = new Piece[8][8];
        setupPieces();
    }

    private void setupPieces() {
        // Rooks
        board[0][0] = new Rook(false);
        board[0][7] = new Rook(false);
        board[7][0] = new Rook(true);
        board[7][7] = new Rook(true);

        // Knights
        board[0][1] = new Knight(false);
        board[0][6] = new Knight(false);
        board[7][1] = new Knight(true);
        board[7][6] = new Knight(true);

        // Bishops
        board[0][2] = new Bishop(false);
        board[0][5] = new Bishop(false);
        board[7][2] = new Bishop(true);
        board[7][5] = new Bishop(true);

        // Queens
        board[0][3] = new Queen(false);
        board[7][3] = new Queen(true);

        // Kings
        board[0][4] = new King(false);
        board[7][4] = new King(true);

        // Pawns
        for (int col = 0; col < 8; col++) {
            board[1][col] = new Pawn(false);
            board[6][col] = new Pawn(true);
        }
    }

    public Piece[][] getBoard() {
        return this.board;
    }

    public Piece getPieceAt(Position pos) {
        return board[pos.getRow()][pos.getColumn()];
    }

    public boolean movePiece(Position from, Position to) {
        board[to.getRow()][to.getColumn()] = board[from.getRow()][from.getColumn()];
        board[from.getRow()][from.getColumn()] = null;
        return true;
    }

    public boolean isCheckmate(boolean isWhiteTurn) {
        return false;
    }

}
