package step2.domain;

import java.util.ArrayList;

public class Ladder {
    private int height;
    private int width;

    private ArrayList<Line> lines = new ArrayList<>();

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        for (int i = 0; i < width; i++) {
            lines.add(new Line(height));
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public Ladder apply(ArrayList<Line> lines) {
        this.lines = lines;
        return this;
    }
}
