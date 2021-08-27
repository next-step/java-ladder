package step2.ladderGame.domain.ladder;

import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int INIT = 0;
    private static final int MINUS = -1;

    private List<Point> points = new ArrayList<>();

    public Line(int height) {
        for (int i = INIT; i < height; i++) {
            points.add(new Point());
        }
    }

    public Line(int countOfPerson, horizontalLineGenerationStrategy horizontalLineGenerationStrategy) {
        points.add(new Point(false));
        for (int i = INIT; i < countOfPerson + MINUS; i++) {
            Point prePoint = points.get(i);
            points.add(new Point(horizontalLineGenerationStrategy.createHorizontalLine(prePoint)));
        }
    }

    public List<Point> getPoints() {
        return this.points;
    }

}
