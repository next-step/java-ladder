package step2.domain;

import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
