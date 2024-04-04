package main;

import main.Game;

import javax.swing.*;




public class Main {
    private static int WIDTH;
    private static int HEIGHT;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Help me");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocation(0, 0);
        frame.setSize(500,500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        HEIGHT = frame.getHeight();
        WIDTH = frame.getWidth();

        Game game = new Game();
        frame.add(game);

        frame.pack();

        frame.setVisible(true);

        game.startGameThread();


    }
}
