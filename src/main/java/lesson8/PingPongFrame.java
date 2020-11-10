package lesson8;

import javax.swing.*;
import java.io.IOException;

public class PingPongFrame extends JFrame {

    public PingPongFrame() throws IOException {
        PingPongGame game = new PingPongGame();
        setTitle("PingPong Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocation(400, 400);
        add(game);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new PingPongFrame();

    }
}