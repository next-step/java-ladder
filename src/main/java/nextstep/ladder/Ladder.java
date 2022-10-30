package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
