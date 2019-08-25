package com.se116;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 900;
    private final int B_HEIGHT = 900;
    private final int DOT_SIZE = 10;


    private final int ALL_BLOCKS = 300;
    private final int RAND_POS = 87;
    private final int DELAY = 140;
    private final long OBSTACLES_FREQUENCY = 2000L;

    private Player player1 = new Player(false, true, false, false, 50, 50);
    private Player player2 = new Player(true, false, false, false, 500, 500);


    private ArrayList<Obstacle> obstacleArrayList = new ArrayList<>();
    private Long obstaclesLocatedAt;

    private boolean inGame = true;
    private boolean isWon = false;

    private Timer timer;
    private Image apple;
    private Image circle_red;
    private Image triangle_red;
    private Image square_red;
    private Image circle_yellow;
    private Image triangle_yellow;
    private Image square_yellow;

    private Menu menu;
    private Character character;
    private IS_WON IS_WON;

    public Board() {
        character = new Character();
        menu = new Menu();
        IS_WON = new IS_WON();
        this.addMouseListener(new MouseINPUT());
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {


        ImageIcon iia = new ImageIcon("resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("resources/circleRED.png");
        circle_red = iih.getImage();

        ImageIcon iih5 = new ImageIcon("resources/triangleRED.png");
        triangle_red = iih5.getImage();

        ImageIcon iih3 = new ImageIcon("resources/rectangleRED.png");
        square_red = iih3.getImage();

        ImageIcon iih2 = new ImageIcon("resources/circleYELLOW.png");
        circle_yellow = iih2.getImage();

        ImageIcon ii6 = new ImageIcon("resources/triangleYELLOW.png");
        triangle_yellow = ii6.getImage();

        ImageIcon iih4 = new ImageIcon("resources/rectangleYELLOW.png");
        square_yellow = iih4.getImage();

    }

    private void initGame() {

        locateBlocks();
        timer = new Timer(DELAY, this);

        timer.start();


    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

            if (inGame) {
                drawSHAPES(g);
                Toolkit.getDefaultToolkit().sync();
            } else if (isWon) {
                IS_WON.render(g);
            } else {
                gameOver(g);
            }


        if (Enumerate.state == Enumerate.STATE.MENU) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, B_WIDTH, B_HEIGHT);
            menu.render(g);
        } else if (Enumerate.state == Enumerate.STATE.CHARACTER) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, B_WIDTH, B_HEIGHT);
            character.render(g);
        }
    }

    private void drawSHAPES(Graphics g) {
        for (Obstacle obstacle : obstacleArrayList) {
            g.drawImage(apple, obstacle.getX(), obstacle.getY(), this);
        }
        if (Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.CIRCLE_YELLOW) {
            g.drawImage(circle_yellow, player1.getX(), player1.getY(), this);
        }

        if (Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.SQUARE_YELLOW) {
            g.drawImage(square_yellow, player1.getX(), player1.getY(), this);
        }

        if (Enumerate.shapes_yellow == Enumerate.SHAPES_YELLOW.TRIANGLE_YELLOW) {
            g.drawImage(triangle_yellow, player1.getX(), player1.getY(), this);
        }

        if (Enumerate.shapes_red == Enumerate.SHAPES_RED.CIRCLE_RED) {
            g.drawImage(circle_red, player2.getX(), player2.getY(), this);
        }

        if (Enumerate.shapes_red == Enumerate.SHAPES_RED.SQUARE_RED) {
            g.drawImage(square_red, player2.getX(), player2.getY(), this);
        }

        if (Enumerate.shapes_red == Enumerate.SHAPES_RED.TRIANGLE_RED) {
            g.drawImage(triangle_red, player2.getX(), player2.getY(), this);
        }
    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }


    private void checkApple() {

        if ((player1.getX() == 0) && (player1.getY() == 0)) {
            locateBlocks();
        }

        if ((player2.getX() == 0) && (player2.getY() == 0)) {
            locateBlocks();
        }
    }


    private void checkCollision(Player player1, Player player2) {


        if (Enumerate.state == Enumerate.STATE.IN_GAME) {

            if (((player1.getX() == player2.getX()) && (player1.getY() == player2.getY()))) {
                inGame = false;
                isWon = true;
                Enumerate.state = Enumerate.STATE.IS_WON;

            }

            for (Obstacle obstacle : obstacleArrayList) {
                if (((player1.getX() == obstacle.getX() && player1.getY() == obstacle.getY())) || ((player2.getX() == obstacle.getX() && player2.getY() == obstacle.getY()))) {
                    inGame = false;
                }
            }

            if (player1.getY() >= B_HEIGHT || player2.getX() >= B_HEIGHT) {
                inGame = false;
            }

            if (player1.getY() < 0 || player2.getY() < 0) {
                inGame = false;
            }

            if (player1.getX() >= B_WIDTH || player2.getX() >= B_WIDTH) {
                inGame = false;
            }

            if (player1.getX() < 0 || player2.getX() < 0) {
                inGame = false;
            }

            if (!inGame) {
                timer.stop();
            }
        }


    }

    public void locateBlocks() {
        long now = System.currentTimeMillis();
        if (obstaclesLocatedAt == null || now > obstaclesLocatedAt + OBSTACLES_FREQUENCY) {
            obstacleArrayList.clear();
            for (int i = 0; i < ALL_BLOCKS; i++) {
                int x = (int) ((Math.random() * RAND_POS)) * DOT_SIZE;
                int y = (int) ((Math.random() * RAND_POS)) * DOT_SIZE;

                if (!((x == player1.getX() && y == player1.getY() || (x == player2.getX() && y == player2.getY())))) {
                    if (!((x == player1.getX() + 1 && y == player1.getY() || (x == player2.getX() + 1 && y == player2.getY())))) {
                        if (!((x == player1.getX() - 1 && y == player1.getY() || (x == player2.getX() - 1 && y == player2.getY())))) {
                            if (!((x == player1.getX() && y == player1.getY() + 1 || (x == player2.getX() && y == player2.getY() + 1)))) {
                                if (!((x == player1.getX() && y == player1.getY() - 1 || (x == player2.getX() && y == player2.getY() - 1)))) {
                                    if (!((x == player1.getX() + 1 && y == player1.getY() + 1 || (x == player2.getX() + 1 && y == player2.getY() + 1)))) {
                                        if (!((x == player1.getX() + 1 && y == player1.getY() - 1 || (x == player2.getX() + 1 && y == player2.getY() - 1)))) {
                                            if (!((x == player1.getX() - 1 && y == player1.getY() - 1 || (x == player2.getX() - 1 && y == player2.getY() - 1)))) {
                                                if (!((x == player1.getX() - 1 && y == player1.getY() + 1 || (x == player2.getX() - 1 && y == player2.getY() + 1)))) {

                                                    Obstacle obstacle = new Obstacle(x, y);
                                                    obstacleArrayList.add(obstacle);
                                                }
                                                obstaclesLocatedAt = now;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (Enumerate.state == Enumerate.STATE.IN_GAME) {
            if (inGame) {
                checkApple();
                checkCollision(player1, player2);
                player1.move();
                player2.move();
                locateBlocks(); //
            }
            repaint();
        } else if (Enumerate.state == Enumerate.STATE.CHARACTER) {
            repaint();

        }
        else if( Enumerate.state == Enumerate.STATE.IS_WON){
            repaint();
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            player1.moveControlPlayer1(key);
            player2.moveControlPlayer2(key);
        }

    }

}
