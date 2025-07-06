package view;

import model.Move;
import model.Piece;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Square extends JButton {
    private final String PATH = "../assets/pieces/";
    private final int row;
    private final int column;
    private Color backgroundColor;
    private boolean hasPiece;
    private Move move;

    public Square(int row, int column, Color backgroundColor, Piece piece) {
        this.row = row;
        this.column = column;
        this.backgroundColor = backgroundColor;

        if (piece != null) {
            drawPiece(piece);
        }

        int x = (column + 1) * 50;
        int y = (row + 1) * 50;
        setBounds(x, y, 50, 50);
        setBackground(backgroundColor);
    }

    public void drawPiece(Piece piece) {
        try{

            if(piece == null) {
                setIcon(null);
                this.hasPiece = false;
                return;
            }

            String color = piece.isWhite() ? "white" : "black";
            Image img = ImageIO.read(getClass().getResource((PATH + color + "/" + piece.getClass().getSimpleName().toLowerCase() + ".png")));
            img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(img));
            this.hasPiece = true;
        }
        catch (IOException e) {
            throw new RuntimeException("Unknown image for the piece!");
        }
    }

    public boolean hasPiece() {
        return this.hasPiece;
    }

    public void setMovable(Move move){
        if(move == null) {
            setBackground(this.backgroundColor);
            this.move = null;
            return;
        }
        this.move = move;
        setBackground(Color.YELLOW);
    }

    public Move getMove() {
        return this.move;
    }

    public boolean isMoveAction() {
        return getBackground() == Color.YELLOW ? true : false;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
