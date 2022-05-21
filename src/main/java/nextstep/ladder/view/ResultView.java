package nextstep.ladder.view;

import nextstep.ladder.model.ladder.*;
import nextstep.ladder.model.player.People;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {
    private static final String EMPTY_PEOPLE_MESSAGE = "참여자가 존재하지 않습니다.";
    private static final String EMPTY_LINE_MESSAGE = "사다리가 존재하지 않습니다.";
    private static final String RESULT_MESSAGE = "사다리 결과";
    private static final String EMPTY_SPACE = "";
    private static final String DOUBLE_EMPTY_SPACE = "  ";
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

    private static Function<List<Point>, String> drawing() {
        return points -> points
                .stream()
                .map(ResultView::joining)
                .reduce((prev, next) -> prev + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_LINE_MESSAGE));
    }

    private static void printLines(Lines lines) {
        String serialize = lines.unwrap()
                .stream()
                .map(Line::points)
                .map(drawing())
                .collect(Collectors.joining(System.lineSeparator()));

        println(serialize);
    }

    private static <T> void printList(List<T> list) {
        String serialize = list
                .stream()
                .map(Object::toString)
                .reduce((prev, next) -> prev + DOUBLE_EMPTY_SPACE + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_PEOPLE_MESSAGE));

        println(serialize);
    }

    private static void printEndPoints(EndPoints endPoints) {
        printList(endPoints.unwrap());
    }

    private static void printName(People people) {
        printList(people.unwrap());
    }

    public static void printLadder(Ladder ladder) {
        println(RESULT_MESSAGE);
        println();
        printLines(ladder.lines());
        printEndPoints(ladder.endPoints());
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
