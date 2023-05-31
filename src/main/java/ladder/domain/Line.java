package ladder.domain;

import ladder.domain.strategy.LadderGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, LadderGeneratorStrategy ladderGeneratorStrategy) {
        boolean prePoint = false;
        for (int columnIndex = 0; columnIndex < countOfPerson - 1; columnIndex++) {
            Point point = new Point(ladderGeneratorStrategy, columnIndex);
            if (prePoint) {
                point = new Point(false);
                prePoint = false;
            }
            points.add(point);

            if (point.isLadder()) {
                prePoint = true;
            }
        }
    }

    public String lineToDash() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    |");
        points.forEach(point -> {
            if (point.isLadder()) {
                stringBuilder.append("-----");
            } else {
                stringBuilder.append("     ");
            }
            stringBuilder.append("|");
        });
        return stringBuilder.toString();
    }
}
