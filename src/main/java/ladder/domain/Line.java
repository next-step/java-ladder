package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line of(int numberOfPlayers, LineGenerator lineGenerator) {
        return new Line(lineGenerator.generate(numberOfPlayers));
    }

    public static Line of(List<Boolean> points) {
        return new Line(points);
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
