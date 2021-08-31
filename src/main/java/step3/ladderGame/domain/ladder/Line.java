package step3.ladderGame.domain.ladder;

import step3.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineGenerationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private List<Point> points = new ArrayList<>();

    public Line(int height) {
        for (int i = 0; i < height; i++) {
            points.add(new Point());
        }
    }

    public Line(int countOfPerson, horizontalLineGenerationStrategy horizontalLineGenerationStrategy) {
        points.add(new Point(false));

        IntStream.range(0, countOfPerson - 1).forEach(
                index -> {
                    Point prePoint = points.get(index);
                    points.add(new Point(horizontalLineGenerationStrategy.createHorizontalLine(prePoint)));
                }
        );
    }

    public List<Point> getPoints() {
        return this.points;
    }

}
