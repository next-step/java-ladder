package nextstep.step2.view;

import nextstep.step2.domain.Line;

import java.util.List;

public class ResultView {

    private static final String BAR = "|";
    private static final String LINE = "-----";
    private static final String NO_LINE = "     ";

    public void showResult(List<String> userNames, List<Line> lines) {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
        printUserName(userNames);
        System.out.println();
        printLadderLine(lines);
    }

    private void printUserName(List<String> userNames) {
        userNames.forEach(userName -> System.out.printf("%-6s", userName));
    }

    private void printLadderLine(List<Line> lines) {
        lines.forEach(line -> {
            System.out.print(BAR);
            printLine(line);
            System.out.println();
        });
    }

    private void printLine(Line line) {
        line.getPoints().stream()
                .peek(point -> System.out.print(point ? LINE : NO_LINE))
                .forEach(point -> System.out.print("|"));
    }
}
