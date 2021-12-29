package rick.domain;

import java.util.Objects;
import rick.strategy.LineCreationStrategy;

public class Line {

    private final Points points;

    public Line(int countOfPerson, LineCreationStrategy pointsGenerationStrategy) {
        this(pointsGenerationStrategy.create(countOfPerson));
    }

    public Line(Points points) {
        this.points = points;
    }

    public Points getPoints() {
        return points;
    }

    public int nextPlayerIndex(int playerIndex) {
        if (points.movableToLeft(playerIndex)) {
            return --playerIndex;
        }

        if (points.movableToRight(playerIndex)) {
            return ++playerIndex;
        }

        return playerIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
