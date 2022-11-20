package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String EXIST_LINE_PART = "-----|";
    private static final String NOT_EXIST_LINE_PART = "     |";

    private ResultView() {
    }

    public static void printResult(final List<String> people, final Ladder ladder) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        printPeople(people);
        printLadder(ladder);
    }

    private static void printPeople(final List<String> people) {
        System.out.println();
        for (String person : people) {
            System.out.printf("%5s ", person);
        }
        System.out.println();
    }

    private static void printLadder(final Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(ResultView::getLines)
                .forEach(System.out::println);
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
