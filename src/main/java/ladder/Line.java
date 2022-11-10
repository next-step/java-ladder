package ladder;

import java.util.List;

public class Line {
    private Points points;

    public Line(int countOfPerson) {
        this.points = new Points(countOfPerson);
    }

    public List<Boolean> connections() {
        return points.connections();
    }
}
