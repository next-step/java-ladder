package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width) {
        for(int i = 0; i < height; i++) {
            lines.add(new Line(width, () -> true));
        }
    }

    public List<Line> height() {
        return lines;
    }
}
