package game;

/**
 * Created by Evan_2 on 2017-05-03.
 */
public class Snake {
    private int width, height;
    private int updateTick = 0;
    private int[] position = {14, 14};
    private int[] direction = {1, 0};

    public int[] pixels;

    public Snake (int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public Snake () {
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void update() {

        if (updateTick >= 5) {

            //this.position[0]++; // move +-x
            this.position[1]++;
            if (this.position[0] < 0) this.position[0]+=width;
            if (this.position[0] >= width) this.position[0]-=width;
            if (this.position[1] < 0) this.position[1]+=height;
            if (this.position[1] >= height) this.position[1]-=height;



            updateTick = 0;
        }else updateTick++;

        //this.position[0]--; // move +-y
    }

    public void render() {
        pixels[position[0] + width*position[1]] = 0xff00ff;
    }
}
