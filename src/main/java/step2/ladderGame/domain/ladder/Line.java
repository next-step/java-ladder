package step2.ladderGame.domain.ladder;

import step2.ladderGame.domain.ladder.pointGenerationStrategy.LadderRandomGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Point> points = new ArrayList<>();

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }
    }

    public Line(int height, LadderRandomGenerationStrategy ladderRandomGenerationStrategy, Line preLine) {
        for (int i = 0; i < height; i++) {
            Point prePoint = preLine.getPoint(i);
            points.add(new Point(ladderRandomGenerationStrategy.createLadder(prePoint)));
        }
    }

    public Point getPoint(int floor) {
        return points.get(floor);
    }

    public List<Point> getPoints() {
        return this.points;
    }

}
