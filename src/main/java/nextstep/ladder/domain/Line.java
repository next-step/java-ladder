package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Bridges bridges;

    private Line(int width) {
        bridges = new Bridges(width);
    }

    static List<Line> createLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }
        return lines;
    }

    public List<Boolean> getBridges() {
        return bridges.getBridges();
    }
}
