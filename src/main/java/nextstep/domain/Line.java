package nextstep.domain;

import nextstep.strategy.LineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int MINIMUM_NUMBER_OF_PEOPLE = 2;
    private List<Direction> directions = new ArrayList<>();
    private LineStrategy lineStrategy;

    public Line(int countPerson, LineStrategy lineStrategy) {
        if (countPerson < MINIMUM_NUMBER_OF_PEOPLE) {
            throw new IllegalArgumentException("최소 2명 이상이 필요하다.");
        }
        this.lineStrategy = lineStrategy;

        directions = of(countPerson, lineStrategy);
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }

    public List<Direction> of(int count, LineStrategy lineStrategy) {
        directions.add(Direction.init(false));

        for (int point = 1; point < count - 1; point++) {
            Direction insert = directions.get(point - 1).insert(lineStrategy.generate());
            directions.add(insert);
        }
        directions.add(directions.get(count - 2).last());

        return Collections.unmodifiableList(directions);
    }

    public int move(int idx) {
        Position position = new Position(idx);
        int point = directions.get(idx).move();
        return position.move(point);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + directions +
                '}';
    }
}
