package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {

    private static final String STRAIGHT_LINE = "-----|";
    private static final String EMPTY_LINE = "     |";

    public void printResult(List<String> userNames, List<Line> lines) {
        System.out.println("실행 결과\n");

        printUserNames(userNames);
        printLines(lines);
    }

    private void printLines(List<Line> lines) {
        lines.forEach(this::printPoints);
    }

    private void printPoints(Line line) {
        line.getPoints().forEach(point -> System.out.print(findLine(point)));
        System.out.println();
    }

    private String findLine(Point point) {
        if (point.isLine()) {
            return STRAIGHT_LINE;
        }

        return EMPTY_LINE;
    }

    private void printUserNames(List<String> userNames) {
        userNames.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }
}
