package ladder.domain;

public class Ladder {

    private final Points points;

    private Ladder(Points points) {
        this.points = points;
    }

    public static Ladder of(int numberOfPoints) {
        return new Ladder(generatePoints(numberOfPoints));
    }

    private static Points generatePoints(int numberOfPoints) {
        return Points.ofCount(numberOfPoints);
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
