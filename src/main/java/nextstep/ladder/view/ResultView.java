package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String START = "사다리 결과";
    private static final String RESULT = "실행 결과";
    private static final int MAX_LENGTH = 5;
    private static final String LADDER_LINE = "|";
    private static final String LADDER_POINT = "-".repeat(MAX_LENGTH);
    private static final String LADDER_BLANK = " ".repeat(MAX_LENGTH);
    private static final String LADDER_START = "   ";
    private static final String BLANK = "  ";
    private static final Name ALL = new Name("all");

    public static void printLadder(Names names, Ladder ladder, Results results) {
        System.out.println(START);
        printNames(names.values());
        printLadderLine(ladder.lines());
        printResult(results.values());
    }

    private static void printNames(List<Name> names) {
        names.stream().forEach(name -> System.out.print(name.value() + BLANK));
        System.out.println();
    }

    private static void printLadderLine(List<Line> ladder) {
        ladder.stream().forEach(line -> System.out.println(LADDER_START + printLine(line) + LADDER_LINE));
    }

    private static String printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        line.points().stream().forEach(point -> {
            builder.append(LADDER_LINE);
            builder.append(printLadderPoint(point));
        });
        return builder.toString();
    }

    private static void printResult(List<Result> results) {
        results.stream().forEach(result -> System.out.print(result.value() + BLANK));
        System.out.println();
        System.out.println();
    }

    private static String printLadderPoint(boolean point) {
        if (point) {
            return LADDER_POINT;
        }
        return LADDER_BLANK;
    }

    public static void printUserResult(LadderResult ladderResult, Name name) {
        System.out.println(RESULT);
        if (name.equals(ALL)) {
            printAllResult(ladderResult);
            return;
        }
        System.out.println(ladderResult.result(name).value());
    }

    private static void printAllResult(LadderResult ladderResult) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Name, Result> entry : ladderResult.results().entrySet()) {
            builder.append(entry.getKey().value());
            builder.append(" : ");
            builder.append(entry.getValue().value());
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
