package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int height;

    private List<Line> lines = new ArrayList<>();

    public void setHeight(int height) {
        this.height = height;
    }

    public void makeLine(int size) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(size));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
