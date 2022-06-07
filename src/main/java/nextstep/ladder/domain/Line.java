package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Point> points;

    private static final RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

    public Line(int numberOfParticipants) {
        this.points = new ArrayList<>();
        for (int i = 0; i < numberOfParticipants - 1; i++) {
            this.points.add(new Point());
        }
        makePoints();
    }

    private void makePoints() {
        for(int i = 0; i < this.points.size(); i++) {
            this.points.set(i, isLinkable(i, randomLineStrategy));
        }
    }

    private Point isLinkable(int i, LineStrategy lineStrategy) {
        return this.points.get(i).randomLink(lineStrategy, previousPointLinked(i), nextPointLinked(i));
    }

    private boolean previousPointLinked(int index) {
        boolean previousPointLinked = false;
        if (index - 1 >= 0) {
            previousPointLinked = this.points.get(index - 1).linked();
        }

        return previousPointLinked;
    }

    private boolean nextPointLinked(int index) {
        boolean nextPointLinked = false;
        if (index + 1 < this.points.size()) {
            nextPointLinked = this.points.get(index + 1).linked();
        }

        return nextPointLinked;
    }


    public List<Point> points() {
        return points;
    }
}
