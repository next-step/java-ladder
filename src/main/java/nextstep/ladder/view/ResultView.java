package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

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
    private static final String NEXT_LINE = "\n";

    public static void printLadder(Names names, Ladder ladder, Results results) {
        System.out.println(START);
        printNames(names.values());
        printLadderLine(ladder.lines());
        printResult(results.values());
    }

    private static void printNames(List<Name> names) {
        StringBuilder builder = new StringBuilder();
        names.stream().forEach(name -> builder.append(name.value()).append(BLANK));
        System.out.println(builder.toString());
    }

    private static void printLadderLine(List<Line> ladder) {
        StringBuilder builder = new StringBuilder();
        ladder.stream().forEach(line -> builder.append(LADDER_START).append(printLine(line)));
        System.out.print(builder.toString());
    }

    private static String printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        line.points().stream().forEach(point -> {
            builder.append(LADDER_LINE).append(printLadderPoint(point.isRight()));
        });
        builder.append(NEXT_LINE);
        return builder.toString();
    }

    private static void printResult(List<Result> results) {
        StringBuilder builder = new StringBuilder();
        results.stream().forEach(result -> builder.append(result.value()).append(BLANK));
        System.out.println(builder.toString());
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
        ladderResult.results()
                .entrySet().stream()
                .forEach(entry -> {
                    builder.append(printReusltText(entry.getKey(), entry.getValue()));
                });
        System.out.println(builder.toString());
    }

    private static String printReusltText(Name name, Result result) {
        return name.value() + " : " + result.value() + NEXT_LINE;
    }
}
