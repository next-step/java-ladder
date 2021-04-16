package nextstep.ladder.domain;

public class Line {
    private final CrossingPoints crossingPoints;

    public Line(CrossingPoints crossingPoints) {
        this.crossingPoints = crossingPoints;
    }

    public int move(int index) {
        return crossingPoints.move(index);
    }

    public CrossingPoints crossingPoints() {
        return crossingPoints;
    }
}