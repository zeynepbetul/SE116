package com.se116;

public class Enumerate {

    public enum STATE{
        IN_GAME,
        MENU,
        CHARACTER,
        IS_WON,

    }
    public enum SHAPES_RED{
        CIRCLE_RED,
        SQUARE_RED,
        TRIANGLE_RED
    }

    public enum SHAPES_YELLOW{
        CIRCLE_YELLOW,
        SQUARE_YELLOW,
        TRIANGLE_YELLOW
    }


    public static STATE state = STATE.MENU;
    public static SHAPES_RED shapes_red = null;
    public static SHAPES_YELLOW shapes_yellow = null;


}
