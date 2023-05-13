package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> coordinate = new ArrayList<>();

    public Ladder(List<String> people, int height) {

        for (int i = 0; i < height; i++) {
            coordinate.add(new Line(people.size()));
        }

    }

    public List<Line> coordinate() {
        return this.coordinate;
    }
}
