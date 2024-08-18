package org.game.snake;
import java.awt.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Board board = new Board();
        board.setBackground(Color.BLACK);
        board.setPreferredSize(new Dimension(300, 300));
        frame.add(board);
        frame.pack();
        TimerListener timerActionListener = new TimerListener(board);
        Timer timer = new Timer(140, timerActionListener);
        board.setTimer(timer);
        timer.start();
        DirectionKeyListener changeDirectionKeyListener = new DirectionKeyListener(board);
        frame.addKeyListener(changeDirectionKeyListener);
    }
}
