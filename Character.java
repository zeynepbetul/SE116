package com.se116;


import javax.swing.*;
import java.awt.*;

public class Character extends JPanel {

    private Rectangle selectCharacter = new Rectangle(900/ 2 - 200,130,100,50);
    private Rectangle selectCharacter2 = new Rectangle(900/ 2 + 100 ,130,100,50);
    private Rectangle rectangle = new Rectangle(900/2 - 230, 220,25,25);
    private Rectangle start = new Rectangle(650,500,80,30);

    ImageIcon iih4 = new ImageIcon("resources/yellowSquare.png");
    ImageIcon iih3 = new ImageIcon("resources/redSquare.png");

    ImageIcon iih5 = new ImageIcon("resources/redTriangle.png");
    ImageIcon ii6 = new ImageIcon("resources/yellowTriangle.png");

    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        Font font0 = new Font("arial",Font.BOLD,20);
        g.setFont(font0);
        g.setColor(Color.white);
        g.drawString(User.player1,280  ,selectCharacter.y + 30);
        g2d.draw(selectCharacter);


        Font font1 = new Font("arial", Font.BOLD,20);
        g.setFont(font1);
        g.setColor(Color.white);
        g.drawString(User.player2,  575 , selectCharacter2.y + 30);
        g2d.draw(selectCharacter2);


        Font font2 = new Font("arial",Font.BOLD,15);
        g.setFont(font2);
        g.setColor(Color.white);
        g.drawString("START",start.x  + 12,start.y + 17);
        g2d.draw(start);


        g.setColor(Color.yellow);
        g.fillRect(rectangle.x,rectangle.y,25,25);

        g.setColor(Color.yellow);
        g.fillOval(900 /2 - 175,220,25,25);
        g.drawImage(ii6.getImage(), 900/ 2 - 135,225,this);



        g.setColor(Color.red);
        g.fillRect(900/ 2 + 70,220,25,25);
        g.setColor(Color.red);
        g.fillOval(900/ 2 + 125,220,25,25);

        g.drawImage(iih5.getImage(),900/2 + 170, 225,this);


        if(Enumerate.shapes_red == Enumerate.SHAPES_RED.CIRCLE_RED){
            g.setColor(Color.red);
            g.fillOval(590,350,25,25);
        }
        if(Enumerate.shapes_red == Enumerate.SHAPES_RED.TRIANGLE_RED){
            g.drawImage(iih5.getImage(),590,350,this);
        }
        if(Enumerate.shapes_red == Enumerate.SHAPES_RED.SQUARE_RED){
            g.drawImage(iih3.getImage(),590,350,this);
        }

        if(Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.CIRCLE_YELLOW){
            g.setColor(Color.yellow);
            g.fillOval(290,350,25,25);
        }
        if(Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.TRIANGLE_YELLOW){
            g.drawImage(ii6.getImage(),290,350,this);
        }
        if(Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.SQUARE_YELLOW){
            g.drawImage(iih4.getImage(),290,350,this);
        }




    }


}
