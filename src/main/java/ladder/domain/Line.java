package ladder.domain;

import java.util.List;

public class Line {
    private final Crosses crosses;

    public Line(int countOfPlayer) {
        this(countOfPlayer, new RandomPointStrategy());
    }

    private Line(int countOfPlayer, PointStrategy strategy) {
        List<Point> points = PointFactory.create(countOfPlayer, strategy);
        this.crosses = Crosses.from(points);
    }

    public List<Boolean> getPoints() {
        return crosses.getPoints();
    }

    public int move(int idx) {
        return crosses.move(idx);
    }

}
