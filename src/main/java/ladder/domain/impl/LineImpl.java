package ladder.domain.impl;

import ladder.domain.engine.Line;
import ladder.domain.engine.LineGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineImpl implements Line {

    private final List<Boolean> points;

    private LineImpl(List<Boolean> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line of(int numberOfPlayers, LineGenerator lineGenerator) {
        return new LineImpl(lineGenerator.generate(numberOfPlayers));
    }

    public static Line of(List<Boolean> points) {
        return new LineImpl(points);
    }

    public List<Boolean> points() {
        return Collections.unmodifiableList(points);
    }

    @Override
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
