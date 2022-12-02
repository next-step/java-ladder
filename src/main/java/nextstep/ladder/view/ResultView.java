package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResults;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LADDER_RESULT_START_MESSAGE = "사다리 결과";
    private static final String EXIST_LINE_PART = "-----|";
    private static final String NOT_EXIST_LINE_PART = "     |";
    private static final String RESULT_MESSAGE = "실행결과";


    private ResultView() {
    }

    public static void printResult(final List<String> people, final Ladder ladder, final List<String> playResults) {
        System.out.println("\n" + LADDER_RESULT_START_MESSAGE);
        printPeople(people);
        printLadder(ladder, playResults);
    }

    public static void printLadderResult(final LadderResults ladderResults, final String name) {
        System.out.println("\n" + RESULT_MESSAGE);
        if ("all".equals(name)) {
            printAllLadderResults(ladderResults);
            return;
        }
        System.out.println(ladderResults.getResult(name));
    }

    private static void printAllLadderResults(final LadderResults ladderResults) {
        for (Map.Entry<String, String> entry : ladderResults.getResults().entrySet()) {
            System.out.println(String.format("%s : %s", entry.getKey(), entry.getValue()));
        }
    }

    private static void printPeople(final List<String> people) {
        System.out.println();
        for (String person : people) {
            System.out.printf("%5s ", person);
        }
        System.out.println();
    }

    private static void printLadder(final Ladder ladder, final List<String> playResults) {
        for (Line line : ladder.getLines()) {
            String lines = getLines(line);
            System.out.println(lines);
        }
        for (String result : playResults) {
            System.out.printf("%5s ", result);
        }
        System.out.println();
    }

    private static String getLines(final Line line) {
        return line.getCrosses()
                .stream()
                .map(v -> getPart(v.getPoint()))
                .collect(Collectors.joining());
    }

    private static String getPart(final Point point) {
        if (point.isLeft()) {
            return EXIST_LINE_PART;
        }
        return NOT_EXIST_LINE_PART;
    }
}
