package org.game.snake;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private boolean leftDirection;
    private boolean rightDirection;
    private boolean upDirection;
    private boolean downDirection;
    private boolean inGame;

    private int dots;
    private Timer timer;
    private int x[];
    private int y[];
    private int appleHorizontal;
    private int appleVertical;

    public Board() {
        inGame = true;
        dots = 3;
        rightDirection = true;
        leftDirection = false;
        upDirection = false;
        downDirection = false;
        x = new int[900];
        y = new int[900];
        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        int r = (int) (Math.random() * 29);
        appleHorizontal = ((r * 10));
        r = (int) (Math.random() * 29);
        appleVertical = ((r * 10));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ImageIcon imageIconHead = new ImageIcon("src/main/resources/head.png");
        Image head = imageIconHead.getImage();

        ImageIcon imageIconDot = new ImageIcon("src/main/resources/dot.png");
        Image dot = imageIconDot.getImage();

        ImageIcon imageIconApple = new ImageIcon("src/main/resources/apple.png");
        Image apple = imageIconApple.getImage();

        drawSnake(g, head, dot);
        setAppleCoordinates(g, apple);
        move();
        checkCollision();
        gameRunning();
        if (checkAppleCollision()) {
            changeAppleCoordinates(g, apple);
        }
        changeDirection();
    }

    public void drawSnake(Graphics g, Image head, Image dot) {
        for (int z = 0; z < dots; z++) {
            if (z == 0) {
                g.drawImage(head, x[z], y[z], this);
            } else {
                g.drawImage(dot, x[z], y[z], this);
            }
        }
    }

    public void setAppleCoordinates(Graphics g, Image apple) {
        g.drawImage(apple, appleHorizontal, appleVertical, this);
    }

    public void changeAppleCoordinates(Graphics g, Image apple) {
        dots++;
        int place = (int) (Math.random() * 29);
        appleHorizontal = ((place * 10));
        place = (int) (Math.random() * 29);
        appleVertical = ((place * 10));
        g.drawImage(apple, appleHorizontal, appleVertical, this);
    }

    public boolean checkAppleCollision() {
        if (x[0] == appleHorizontal & y[0] == appleVertical) {
            return true;
        } else {
            return false;
        }
    }

    public void move() {
        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }
    }

    public void changeDirection() {
        if (rightDirection) {
            x[0] += 10;
        } else if (leftDirection) {
            x[0] -= 10;
        } else if (upDirection) {
            y[0] -= 10;
        } else if (downDirection) {
            y[0] += 10;
        }
    }

    public void checkCollision() {
        if (x[0] <= 0 || x[0] >= 290) {
            inGame = false;
        }
        if (y[0] <= 0 || y[0] >= 290) {
            inGame = false;
        }

        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }
    }

    public void gameRunning() {
        if (!inGame) {
            timer.stop();
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    public boolean isRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    public boolean isUpDirection() {
        return upDirection;
    }

    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    public boolean isDownDirection() {
        return downDirection;
    }

    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }
}
