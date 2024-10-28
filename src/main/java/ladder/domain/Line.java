package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int numberOfPlayers, LineGenerator lineGenerator) {
        this.points = lineGenerator.generate(numberOfPlayers);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    public int move(int position) {
        if (crossLeft(position)) {
            return position - 1;
        }

        if (crossRight(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean crossLeft(int position) {
        return position > 0 && points.get(position - 1);
    }

    private boolean crossRight(int position) {
        return position < points.size() && points.get(position);
    }
}
