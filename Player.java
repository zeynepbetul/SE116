package com.se116;

import java.awt.event.KeyEvent;

public class Player extends Block {

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    protected static int player1counter= 0;
    protected static int player2counter =0;


    public Player(boolean leftDirection, boolean rightDirection, boolean upDirection, boolean downDirection, int x, int y) {
        super(x, y);
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
        this.upDirection = upDirection;
        this.downDirection = downDirection;
        setX(x);
        setY(y);
    }
//if (Enumerate.state == Enumerate.STATE.IN_GAME) { bunu buraya
    @Override
    public void moveControlPlayer1(int key) {
        if ((key == KeyEvent.VK_RIGHT) && (!isLeftDirection())) {
            setRightDirection(true);
            setUpDirection(false);
            setDownDirection(false);
            player1counter++;
        }

        if ((key == KeyEvent.VK_LEFT) && (!isRightDirection())) {
            setLeftDirection(true);
            setUpDirection(false);
            setDownDirection(false);
            player1counter++;
        }

        if ((key == KeyEvent.VK_DOWN) && (!isUpDirection())) {
            setDownDirection(true);
            setRightDirection(false);
            setLeftDirection(false);
            player1counter++;
        }

        if ((key == KeyEvent.VK_UP) && (!isDownDirection())) {
            setUpDirection(true);
            setRightDirection(false);
            setLeftDirection(false);
            player1counter++;
        }
    }

    @Override
    public void moveControlPlayer2(int key) {
        if ((key == KeyEvent.VK_D) && (!isLeftDirection())) {
            setRightDirection(true);
            setUpDirection(false);
            setDownDirection(false);
            player2counter++;
        }

        if ((key == KeyEvent.VK_A) && (!isRightDirection())) {
            setLeftDirection(true);
            setUpDirection(false);
            setDownDirection(false);
            player2counter++;
        }

        if ((key == KeyEvent.VK_S) && (!isUpDirection())) {
            setDownDirection(true);
            setRightDirection(false);
            setLeftDirection(false);
            player2counter++;
        }

        if ((key == KeyEvent.VK_W) && (!isDownDirection())) {
            setUpDirection(true);
            setRightDirection(false);
            setLeftDirection(false);
            player2counter++;
        }
    }

    public void move() {
        if (isLeftDirection()) {
            setX(getX() - 10);
        }

        if (isRightDirection()) {
            setX(getX() + 10);
        }

        if (isUpDirection()) {
            setY(getY() - 10);
        }

        if (isDownDirection()) {
            setY(getY() + 10);
        }

        }


    @Override
    public boolean isLeftDirection() {
        return leftDirection;
    }

    @Override
    public void setLeftDirection(boolean leftDirection) {
        this.leftDirection = leftDirection;
    }

    @Override
    public boolean isRightDirection() {
        return rightDirection;
    }

    @Override
    public void setRightDirection(boolean rightDirection) {
        this.rightDirection = rightDirection;
    }

    @Override
    public boolean isUpDirection() {
        return upDirection;
    }

    @Override
    public void setUpDirection(boolean upDirection) {
        this.upDirection = upDirection;
    }

    @Override
    public boolean isDownDirection() {
        return downDirection;
    }

    @Override
    public void setDownDirection(boolean downDirection) {
        this.downDirection = downDirection;
    }
}