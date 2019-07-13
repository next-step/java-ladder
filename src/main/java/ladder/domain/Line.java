package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private List<Point> points;

    Line(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public static Line from(int numberOfPlayers) {
        LineMaker lineMaker = new LineMaker();
        return new Line(lineMaker.generatePoints(numberOfPlayers));
    }

    Position travel(Position position) {
        return points.get(position.getPosition()).move(position);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }



}
