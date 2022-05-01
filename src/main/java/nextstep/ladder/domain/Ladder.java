package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int width;
    private final List<Line> lines;

    private Ladder(List<Line> lines, int width) {
        this.lines = lines;
        this.width = width;
    }

    public static Ladder createLadder(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be greater than zero");
        }

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
        return new Ladder(lines, width);
    }

    public void apply(Participants participants) {
        lines.forEach(line -> line.apply(participants));
    }

    public int getWidth() {
        return width;
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
