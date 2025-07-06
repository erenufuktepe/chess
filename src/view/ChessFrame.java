package view;

import javax.swing.*;
import java.awt.*;

public class ChessFrame extends JFrame {
    private String TITLE = "Chess";
    private int WIDTH = 520;
    private int HEIGHT = 550;
    public ChessFrame () {
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        add(new ChessPanel());
        //pack();
        setVisible(true);
    }



}
