package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private Points points;

    public Line(int countOfPerson) {
        this.points = new Points(countOfPerson, new PointsShuffleGenerator());
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points.getPoints());
    }
}
