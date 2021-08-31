package ladder.model;

import java.util.List;


public class Ladder {

    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public int moveFrom(int index) {
        int next = index;
        for (int i = 0; i < getHeight(); i++) {
            next = lines.get(i).move(next);
        }
        return next;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getWidth() {
        return lines.get(0).getWidth();
    }

    public int getHeight() {
        return lines.size();
    }
}
