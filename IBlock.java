package com.se116;

public interface IBlock {

    void moveControlPlayer1(int key);
    void moveControlPlayer2(int key);
    void move();

    boolean isLeftDirection();
    void setLeftDirection(boolean leftDirection);

    boolean isRightDirection();
    void setRightDirection(boolean rightDirection);

    boolean isUpDirection();
    void setUpDirection(boolean upDirection);

    boolean isDownDirection();
    void setDownDirection(boolean downDirection);

    int getX();
    void setX(int x);

    int getY();
    void setY(int y);

}
