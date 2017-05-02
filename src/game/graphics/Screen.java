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

    public void render() {
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels [20+29*width] = 0xff00ff;
            }
        }
    }
}
