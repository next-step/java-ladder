package nextstep.version.refactor.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Line {
    private final List<Points> points;

    public Line(int size, int height, LineCreator lineCreator) {
        this(toLineList(size, height, lineCreator));
    }

    private static List<Points> toLineList(int size, int height, LineCreator lineCreator) {
        List<Points> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(new Points(lineCreator.createBooleanList(size)));
        }
        return points;
    }

    public Line(List<Points> points) {
        this.points = points;
    }

    public Points get(int index) {
        return points.get(index);
    }

    public Integer size() {
        return this.points.size();
    }

    public MatchResult play() {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        int size = this.points.get(0).size();

        for (int position = 0; position < size; position++) {
            result.put(position, createMoveResultByPosition(position));
        }
        return new MatchResult(result);
    }

    private int createMoveResultByPosition(int position) {
        int moveResult = 0;
        for (Points point : points) {
            moveResult = point.move(position);
        }
        return moveResult;
    }
}
