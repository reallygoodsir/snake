package org.game.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DirectionKeyListener extends KeyAdapter {
    private Board board;
    public DirectionKeyListener(Board board) {
        this.board = board;
    }

    public void keyPressed(KeyEvent e) {
        int press = e.getKeyCode();

        if (press == KeyEvent.VK_DOWN && (!board.isUpDirection())) {
            board.setLeftDirection(false);
            board.setRightDirection(false);
            board.setUpDirection(false);
            board.setDownDirection(true);
        }
        if (press == KeyEvent.VK_UP && (!board.isDownDirection())) {
            board.setLeftDirection(false);
            board.setRightDirection(false);
            board.setUpDirection(true);
            board.setDownDirection(false);
        }
        if ((press == KeyEvent.VK_LEFT) && (!board.isRightDirection())) {
            board.setLeftDirection(true);
            board.setRightDirection(false);
            board.setUpDirection(false);
            board.setDownDirection(false);
        }
        if (press == KeyEvent.VK_RIGHT && (!board.isLeftDirection())) {
            board.setLeftDirection(false);
            board.setRightDirection(true);
            board.setUpDirection(false);
            board.setDownDirection(false);
        }
    }
}
