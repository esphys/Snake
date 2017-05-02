package game;

import game.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Created by Evan_2 on 2017-04-30.
 */
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static int WIDTH = 30;
    public static int HEIGHT = 30;
    public static int SCALE = 15;

    private Thread thread;
    private JFrame frame;
    private boolean running = false;

    private Screen screen;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
        setPreferredSize(size); // in Canvas

        screen = new Screen(WIDTH, HEIGHT);
        frame = new JFrame();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Snake");
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            update();
            render();

        }
    }

    public void update() {

    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        // Dis where your graphics stuff go.
        g.setColor(Color.BLACK);
        g.fillRect(0,0, getWidth(), getHeight());
        g.dispose();
        bs.show();

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Snake");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
