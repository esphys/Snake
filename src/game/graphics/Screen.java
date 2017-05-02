package game.graphics;

/**
 * Created by Evan_2 on 2017-05-02.
 */
public class Screen {

    private int width, height;
    public int[] pixels;

    public Screen (int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }
}
