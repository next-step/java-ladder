package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public void generateLines() {
        lines.forEach(Line::generateConnection);
    }
}
