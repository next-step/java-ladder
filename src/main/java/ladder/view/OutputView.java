package ladder.view;

import ladder.domain.LadderResult;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.domain.Result;
import ladder.domain.Results;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String LINE_DIVISION = "|";
    private static final String PRINT_NAME = "%6s";
    private static final String BLANK = "      ";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String NONE_LINE = "     ";

    private OutputView() {
    }

    public static void printLadder(Names joinMembers, Ladder ladder, Results results) {
        System.out.println(LADDER_RESULT_MESSAGE);

        printNames(joinMembers);
        printLines(ladder.getLines());
        printResults(results);

        System.out.println();
    }

    private static void printNames(Names names) {
        names.getNames()
                .forEach(name -> System.out.printf(PRINT_NAME, name));
        System.out.println();
    }

    private static void printLines(List<Line> lines) {
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(BLANK + LINE_DIVISION);

        line.getPoints().stream()
                .limit(line.pointSize() - 1)
                .forEach(OutputView::printPoint);

        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.canDraw()) {
            System.out.print(HORIZONTAL_LINE + LINE_DIVISION);
            return;
        }
        System.out.print(NONE_LINE + LINE_DIVISION);
    }

    private static void printResults(Results results) {
        results.getResults()
                .forEach(result -> System.out.printf(PRINT_NAME, result));
    }

    public static void printLadderResult(LadderResult ladderResult) {
        boolean progress = true;

        while (progress) {
            String name = InputView.requestResultGamer();
            Map<Name, Result> userResult = ladderResult.findPlayerResult(name);
            OutputView.printGameResult(userResult, name);

            progress = isProgress(name);
        }
    }

    private static void printGameResult(Map<Name, Result> ladderResult, String name) {
        System.out.println(RESULT_MESSAGE);

        if (name.equals(LadderResult.ALL_USERS)) {
            ladderResult.forEach((key, value) -> System.out.println(key + " : " + value));
            return;
        }

        ladderResult.forEach((key, value) -> System.out.println(value));
    }

    private static boolean isProgress(String name) {
        return !name.equals(LadderResult.ALL_USERS);
    }
}
