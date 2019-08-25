package com.se116;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseINPUT implements MouseListener {


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        /**
         *     public Rectangle playButton =  new Rectangle(900 / 2 - 60 ,150,100,50);
         *     public Rectangle helpButton =  new Rectangle(900 / 2 - 60 ,250,100,50);
         *     public Rectangle quitButton =  new Rectangle(900 / 2 - 60 ,350,100,50);
         *     private Rectangle start = new Rectangle(650,500,80,30);
         */

        if (Enumerate.state == Enumerate.STATE.MENU) {
            if (mx >= 900 / 2 - 60 && mx <= 900 / 2 + 40) {
                if (my >= 150 && my <= 200) {
                    Enumerate.state = Enumerate.STATE.CHARACTER;
                }
            }


            //Quit Button
            if (mx >= 900 / 2 - 60 && mx <= 900 / 2 + 40) {
                if (my >= 350 && my <= 400) {
                    System.exit(0);
                }
            }

            if (mx >= 900 / 2 - 60 && mx <= 900 / 2 + 40) {
                if (my >= 250 && my <= 300) {
                    Enumerate.state = Enumerate.STATE.CHARACTER;
                }
            }


        }

        if(Enumerate.state == Enumerate.STATE.CHARACTER){
            if (mx >= 650 && mx <= 730) {
                if (my >= 500 && my <= 530) {
                    Enumerate.state = Enumerate.STATE.IN_GAME;
                }
            }

            if(mx >= 900/2 - 230 && mx <= 900/2 - 205){
                if(my >= 220 && my<= 245){
                    Enumerate.shapes_yellow = Enumerate.shapes_yellow.SQUARE_YELLOW;
                }
            }

            if(mx >= 900/2 - 175 && mx <= 900/2 - 150){
                if(my >= 220 && my<= 245){
                    Enumerate.shapes_yellow = Enumerate.shapes_yellow.CIRCLE_YELLOW;
                }
            }

            if(mx >= 900/ 2 - 140 && mx <= 335){
                if(my >= 220 && my<= 245){
                    Enumerate.shapes_yellow = Enumerate.shapes_yellow.TRIANGLE_YELLOW;
                }
            }

            if(mx>= 900/2 +70 && mx<=900/2 + 95){
                if(my >= 220 && my<= 245){
                    Enumerate.shapes_red = Enumerate.shapes_red.SQUARE_RED;
                }
            }

            if(mx>= 900/2 + 125 && mx <= 900/2 + 150){
                if(my >= 220 && my <= 245){
                    Enumerate.shapes_red = Enumerate.shapes_red.CIRCLE_RED;
                }
            }

            if(mx >= 900/2 + 170 && mx <= 900/2 + 200){
                if(my >= 220 && my<= 235){
                    Enumerate.shapes_red = Enumerate.shapes_red.TRIANGLE_RED;

                }
            }
        }

        if(Enumerate.state == Enumerate.STATE.IS_WON){
            if(mx>400 && mx<= 500 ){
                if(my >= 500 && my<= 512){
                    Enumerate.state = Enumerate.STATE.CHARACTER;
                }
            }
            if(mx >= 435 && mx<= 465){
                if(my >= 560 && my<= 575){
                    System.exit(1);
                }
            }

        }
        System.out.println("X: " + mx + "  Y: " + my);
        System.out.println(Enumerate.state);
        System.out.println("YELLOW: " + Enumerate.shapes_yellow);
        System.out.println("RED: " + Enumerate.shapes_red);
        System.out.println();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}



