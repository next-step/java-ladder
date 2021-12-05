package nextstep.laddergame.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson));
        }
    }
}
