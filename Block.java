package com.se116;

public abstract class Block implements IBlock{
    private int x;
    private int y;

    public Block(int x, int y) {
        setX(x);
        setY(y);
    }

    public Block() {
        setX(0);
        setY(0);
    }

    public abstract void moveControlPlayer1(int key);
    public abstract void moveControlPlayer2(int key);
    public abstract void move();

    public abstract boolean isLeftDirection();
    public abstract void setLeftDirection(boolean leftDirection);

    public abstract boolean isRightDirection();
    public abstract void setRightDirection(boolean rightDirection);

    public abstract boolean isUpDirection();
    public abstract void setUpDirection(boolean upDirection);

    public abstract boolean isDownDirection();
    public abstract void setDownDirection(boolean downDirection);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


}
