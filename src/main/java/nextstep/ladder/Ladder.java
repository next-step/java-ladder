package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countPerson));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
