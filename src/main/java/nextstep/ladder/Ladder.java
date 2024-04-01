package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, false));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
