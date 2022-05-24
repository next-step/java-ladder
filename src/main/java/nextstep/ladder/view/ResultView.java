package nextstep.ladder.view;

import nextstep.ladder.model.Game;
import nextstep.ladder.model.ladder.*;
import nextstep.ladder.model.player.People;
import nextstep.ladder.model.player.Person;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static nextstep.ladder.model.ConstantNumber.ZERO;

public class ResultView {
    private static final String EMPTY_PEOPLE_MESSAGE = "참여자가 존재하지 않습니다.";
    private static final String EMPTY_LINE_MESSAGE = "사다리가 존재하지 않습니다.";
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ALL_RESULT_MESSAGE = "%s : %s";
    private static final String EMPTY_SPACE = "";
    private static final String DOUBLE_EMPTY_SPACE = "  ";
    private static final String WIDTH_LINE = "-----";
    private static final String EMPTY_WIDTH_LINE = "     ";
    private static final String HEIGHT_LINE = "|";
    private static final String ALL = "all";

    private ResultView() {
    }

    private static String addWidth(Point prev) {
        if (prev.direction().isRight()) {
            return WIDTH_LINE;
        }
        return EMPTY_WIDTH_LINE;
    }

    private static String joining(Point prev) {
        return String.join(addWidth(prev), HEIGHT_LINE, EMPTY_SPACE);
    }

    private static String drawing(List<Point> points) {
        return points
                .stream()
                .map(ResultView::joining)
                .reduce((prev, next) -> prev + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_LINE_MESSAGE));
    }

    private static void printLines(Lines lines) {
        String serialize = lines.unwrap()
                .stream()
                .map(Line::points)
                .map(ResultView::drawing)
                .collect(Collectors.joining(System.lineSeparator()));

        println(serialize);
    }

    private static void printEndPoints(EndPoints endPoints) {
        printList(endPoints.unwrap());
    }

    private static void printName(People people) {
        printList(people.unwrap());
    }

    private static <T> void printList(List<T> list) {
        String serialize = list
                .stream()
                .map(Object::toString)
                .reduce((prev, next) -> prev + DOUBLE_EMPTY_SPACE + next)
                .orElseThrow(() -> new NullPointerException(EMPTY_PEOPLE_MESSAGE));

        println(serialize);
    }

    public static void printLadder(People people, Ladder ladder) {
        println(LADDER_MESSAGE);
        println();
        printName(people);
        printLines(ladder.lines());
        printEndPoints(ladder.endPoints());
        println();
    }

    public static void printAllResult(Game game) {
        BiFunction<String, EndPoint, String> message = (name, result) ->
                String.format(ALL_RESULT_MESSAGE, name, game.result(name));
        game.people()
                .unwrap()
                .stream()
                .map(Person::toString)
                .forEach(name -> println(message.apply(name, game.result(name))));

        System.exit(ZERO.getValue());
    }

    public static void printResult(String name, Game game) {
        println(RESULT_MESSAGE);

        if (name.equals(ALL)) {
            printAllResult(game);
            return;
        }

        EndPoint endPoint = game.result(name);
        println(endPoint.score());
        println();
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
