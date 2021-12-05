package ladder.model;

import ladder.model.point.Points;

public class Line {

    private final Points points;

    public Line (int countOfPerson) {
        this.points = new Points(countOfPerson);
    }

    public Points getPoints() {
        return points;
    }
}
