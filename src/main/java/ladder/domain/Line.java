package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> points;

    public Line(int numberOfPlayers, LineGenerator lineGenerator) {
        this.points = lineGenerator.generate(numberOfPlayers);
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
