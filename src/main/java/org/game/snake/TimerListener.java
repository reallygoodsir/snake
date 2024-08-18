package org.game.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    private Board board;

    public TimerListener(Board board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board.repaint();
        Toolkit.getDefaultToolkit().sync();
    }
}
