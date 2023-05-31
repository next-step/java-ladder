package ladder.domain;

import ladder.domain.strategy.LadderGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> points = new ArrayList<>();

    public Line(int countOfPerson, LadderGeneratorStrategy ladderGeneratorStrategy) {
        for (int columnIndex = 0; columnIndex < countOfPerson - 1; columnIndex++) {
            Point point = new Point(ladderGeneratorStrategy, columnIndex);
            points.add(point);

            columnIndex += doNotBuildLadderAtNextColumn(columnIndex + 1 < countOfPerson - 1, point.isLadder());
        }
    }

    private int doNotBuildLadderAtNextColumn(boolean validMaxIndex, boolean currentLadder) {
        if (currentLadder && validMaxIndex) {
            points.add(new Point(false));
            return 1;
        }
        return 0;
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
