package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;
import nextstep.ladder.model.Point;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {
    private static final String EMPTY_PEOPLE_MESSAGE = "참여자가 존재하지 않습니다.";
    private static final String EMPTY_LINE_MESSAGE = "사다리가 존재하지 않습니다.";
    private final static String RESULT_MESSAGE = "실행결과";
    private static final String EMPTY_SPACE = "";
    private final static String DOUBLE_EMPTY_SPACE = "  ";
    private static final String WIDTH_LINE = "-----";
    private static final String EMPTY_WIDTH_LINE = "     ";
    private static final String HEIGHT_LINE = "|";

    private ResultView() {
    }

    private static String addWidth(Point prev) {
        if (prev.value()) {
            return WIDTH_LINE;
        }
        return EMPTY_WIDTH_LINE;
    }

    private static String joining(Point prev) {
        return String.join(addWidth(prev), HEIGHT_LINE, EMPTY_SPACE);
    }

    private static Function<Point[], String> drawing() {
        return points -> Arrays
                .stream(points)
                .map(ResultView::joining)
                .reduce((prev, next) -> prev + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_LINE_MESSAGE));
    }

    private static void printLines(Line[] lines) {
        String serialize = Arrays
                .stream(lines)
                .map(Line::points)
                .map(drawing())
                .collect(Collectors.joining(System.lineSeparator()));

        println(serialize);
    }

    private static void printNames(Person[] names) {
        String serialize = Arrays
                .stream(names)
                .map(Person::toString)
                .reduce((prev, next) -> prev + DOUBLE_EMPTY_SPACE + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_PEOPLE_MESSAGE));

        println(serialize);
    }

    public static void printResult(Ladder ladder) {
        println(RESULT_MESSAGE);
        println();
        printNames(ladder.people());
        printLines(ladder.lines());
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
