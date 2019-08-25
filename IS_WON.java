package com.se116;

import javax.swing.*;
import java.awt.*;

public class IS_WON extends JPanel {

    private final int B_WIDTH = 900;
    private final int B_HEIGHT = 900;


    public void render(Graphics g) {


        String msg = "You Won";
        Font small = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, 100);


        String name = User.player1;
        Font small2 = new Font("Helvetica",Font.PLAIN,35);
        g.setColor(Color.yellow);
        g.setFont(small2);
        g.drawString(name,200,180);

        String mouse = "Total Click";
        Font small5 = new Font("Helvetica",Font.ITALIC,28);
        g.setColor(Color.yellow);
        g.setFont(small5);
        g.drawString(mouse,165,240);

        int click = Player.player1counter;
        g.setColor(Color.yellow);
        g.setFont(small5);
        g.drawString(String.valueOf(click),220,285);


        String name2 = User.player2;
        Font small4 = new Font("Helvetica",Font.PLAIN,35);
        g.setColor(Color.red);
        g.setFont(small4);
        g.drawString(name2,650,180);

        g.setColor(Color.red);
        g.setFont(small5);
        g.drawString(mouse,615,240);

        int click2 = Player.player2counter;
        g.setColor(Color.red);
        g.setFont(small5);
        g.drawString(String.valueOf(click2),675,285);


        String msg3 = "Quit";
        Font small3 = new Font("Helvetica", Font.BOLD, 15);
        FontMetrics metrics2 = getFontMetrics(small3);
        g.setColor(new Color(102,0,153));
        g.setFont(small3);
        g.drawString(msg3, (B_WIDTH - metrics2.stringWidth(msg3)) / 2 - 5, B_HEIGHT / 2 + 120);
    }



}
