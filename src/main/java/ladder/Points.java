package ladder;

import java.util.*;

public class Points {
    private List<Boolean> points;

    public Points(int countOfPerson, PointsGenerator pointsGenerator) {
        this.points = pointsGenerator.generate(countOfPerson);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}
