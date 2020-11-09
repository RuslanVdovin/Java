package lesson8;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class PingPongGame extends JPanel implements ActionListener {

    private final int SIZE = 600;
    private int barX = 100;
    private int barY = 530;
    private int ballX = 100;
    private int ballX1;
    private int ballY = 530;
    private Timer timer;
    private int score = 0;
    private boolean inGame = true;
    private boolean left = false;
    private boolean right = true;
    private boolean up = true;
    private boolean down = false;
    private int[][] map;
    private int brickWidth;
    private int brickHeight;

    public void mapGeneration(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
        brickWidth = 500 / col;
        brickHeight = 120 / row;
    }
    public void setBrickValue(int value, int row, int col){
        map[row][col] = value;
    }

    public PingPongGame() throws IOException {
        setBackground(Color.gray);
        mapGeneration(3, 7);
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }


    public void initGame() {
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.setColor(Color.black);
            String scr = "Score: " + score;
            g.drawString(scr, 30, 15);
            g.setColor(Color.WHITE);
            g.fillOval(ballX, ballY, 40, 40);
            g.setColor(Color.BLACK);
            g.fillRect(barX, barY, 100, 20);

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] > 0) {
                        g.setColor(Color.CYAN);
                        g.fillRect(j * brickWidth + 40, i * brickHeight + 50, 50, 20);
                        repaint();
                    }
                }
            }
        } else {
            String str = "Game Over";
            g.setColor(Color.WHITE);
            g.drawString(str, 270, 250);
            restart();
        }
        if (score == 21) {
            inGame = false;
            String str = "You Win!";
            g.setColor(Color.WHITE);
            g.drawString(str, 270, 250);
            restart();
        }
    }
    public void restart(){
        int response = JOptionPane.showConfirmDialog(this, "Restart game?",
                "Restart", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            score = 0;
            inGame = true;
            ballX = 300;
            ballY = 530;
            up = false;
            down = true;
            mapGeneration(3, 7);
            repaint();
        } else if (response == JOptionPane.NO_OPTION) {
            System.exit(1);
        }
    }

    public void move() {
        int ballY1;
        if (up && left) {
            ballX = ballX - 15;
            ballY = ballY + 12;
            ballX1 = ballX + 60;
            ballY1 = ballY + 60;
        } else if (up && right) {
            ballX = ballX + 15;
            ballY = ballY + 12;
            ballX1 = ballX + 60;
            ballY1 = ballY + 60;
        } else if (down && left) {
            ballX = ballX - 15;
            ballY = ballY - 12;
            ballX1 = ballX + 60;
            ballY1 = ballY + 60;
        } else if (down && right) {
            ballX = ballX + 15;
            ballY = ballY - 12;
            ballX1 = ballX + 60;
            ballY1 = ballY + 60;
        }
    }

    public void checkCollisions() {
        if (new Rectangle(ballX, ballY, 40, 40).
                intersects(barX, barY, 100, 20)) {
            up = false;
            down = true;
        }
        A:
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    int brickX = j * brickWidth + 60;
                    int brickY = i * brickHeight + 50;
                    Rectangle brickRect = new Rectangle(brickX, brickY, 50, 20);
                    Rectangle ballRect = new Rectangle(ballX, ballY, 40,40);
                    if(ballRect.intersects(brickRect)) {
                        if(up == false && down == true) {
                            up = true;
                            down = false;
                        } else if (up == true && down == false) {
                            up = false;
                            down = true;
                        }
                        setBrickValue(0, i, j);
                        score++;
                        repaint();
                        break A;
                    }
                }
            }
        }
        if (ballX1 > SIZE) {
            right = false;
            left = true;
        } else if (ballX < 0) {
            right = true;
            left = false;
        } else if (ballY < 0) {
            up = true;
            down = false;
        } else if (ballY > 600) {
            inGame = false;
        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            repaint();
            checkCollisions();
            move();
        }
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                barX -= 50;
                if(barX <= 5)
                    barX = 0;
            }
            if (key == KeyEvent.VK_RIGHT) {
                barX += 50;
                if (barX >= 490)
                    barX = 500;
            }
        }
    }
}