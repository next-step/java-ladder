package ladder.line;

import ladder.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line(int countOfPerson, LineGenerateStrategy lineGenerateStrategy) {
        boolean isPrevLineConnected = false;

        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currentLineConnection = !isPrevLineConnected && lineGenerateStrategy.generate();
            points.add(currentLineConnection);
            isPrevLineConnected = currentLineConnection;
        }
    }

    public Position move(int position) {
        return move(new Position(position));
    }

    public Position move(Position position) {
        if (position.isGreaterThanZero() && points.get(position.decrease().getPosition())) {
            return position.decrease();
        }

        if (position.isLessThan(points.size()) && points.get(position.getPosition())) {
            return position.increase();
        }
        return position;
    }

    public List<Boolean> getPoints() {
        return points;
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
        return Objects.hashCode(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
