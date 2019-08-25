package com.se116;

import java.awt.*;

public class Menu {

    public Rectangle playButton =  new Rectangle(900 / 2 - 60 ,150,100,50);
    public Rectangle helpButton =  new Rectangle(900 / 2 - 60 ,250,100,50);
    public Rectangle quitButton =  new Rectangle(900/ 2 - 60 ,350,100,50);


    public void render(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("HUG", 383, 100);

        Font fnt1 = new Font("arial", Font.BOLD,30);
        g.setFont(fnt1);
        g.drawString("Play",playButton.x + 20,playButton.y + 30);

        Font fnt2 = new Font("arial", Font.BOLD,30);
        g.setFont(fnt1);
        g.drawString("Option",helpButton.x ,helpButton.y + 30);

        Font fnt3 = new Font("arial", Font.BOLD,30);
        g.setFont(fnt1);
        g.drawString("Quit",quitButton.x + 20,quitButton.y + 30);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
    }


}
