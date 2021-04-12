package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.ConditionStrategy;

import java.util.*;

public class Line {
    public final static int START_INDEX = 1;
    public final static int MIN_PERSON = 2;

    private final List<Point> points = new ArrayList<>();

    public Line (int countOfPlayers, ConditionStrategy conditionStrategy) {
        validation(countOfPlayers);
        create(countOfPlayers, conditionStrategy);
    }

    private void validation(int countOfPerson) {
        if (countOfPerson < MIN_PERSON) {
            throw new IllegalArgumentException("참여자는 최소 2명 이상이어야 합니다.");
        }
    }

    private void create(int countOfPlayers, ConditionStrategy conditionStrategy) {
        points.add(Point.first(conditionStrategy.randomBoolean()));

        for (int i = START_INDEX; i < countOfPlayers - 1; i++) {
            points.add(points.get(i - 1).next(conditionStrategy.randomBoolean()));
        }

        points.add(Point.last(points.get(points.size() - 1)));
    }

    public int nextPosition(int position) {
        return points.get(position)
                .direction()
                .nextIndex();
    }

    public int size() {
        return points.size();
    }

    public List<Point> points(){
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
