package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Square extends JButton {
    private final String PATH = "../assets/pieces/";
    private final int row;
    private final int column;
    private Color backgroundColor;

    public Square(int row, int column, Color backgroundColor) {
        this.row = row;
        this.column = column;
        this.backgroundColor = backgroundColor;
        int x = (column + 1) * 50;
        int y = (row + 1) * 50;
        setBounds(x, y, 50, 50);
        setBackground(backgroundColor);
    }

    protected void drawIcon(boolean isWhite, String className) {
        try{
            String color = isWhite ? "white" : "black";

            if (className == null) {
                setIcon(null);
            }

            Image img = ImageIO.read(getClass().getResource((PATH + color + "/" + className.toLowerCase() + ".png")));
            img = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
            setIcon(new ImageIcon(img));
        }
        catch (IOException exception) {
            throw new RuntimeException("Unknown image for the piece!");
        }
    }

    public void moveIcon(Square to) {
        to.setIcon(this.getIcon());
        this.setIcon(null);
    }

    public boolean hasPiece() {
        return getIcon() != null ? true : false;
    }

    public Square setMovable(boolean movable) {
        setBackground(movable ? Color.YELLOW : this.backgroundColor);
        return this;
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
