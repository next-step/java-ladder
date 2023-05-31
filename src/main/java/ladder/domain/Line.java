package ladder.domain;

import ladder.domain.strategy.LadderGeneratorStrategy;
import ladder.domain.strategy.RandomBuildLadder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, LadderGeneratorStrategy ladderGeneratorStrategy) {
        boolean prePoint = false;
        for (int columnIndex = 0; columnIndex < countOfPerson - 1; columnIndex++) {
            if (prePoint) {
                points.add(new Point(false));
                prePoint = false;
                continue;
            }

            Point point = new Point(ladderGeneratorStrategy, columnIndex);
            if (point.isLadder()) {
                prePoint = true;
            }
            points.add(point);
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
