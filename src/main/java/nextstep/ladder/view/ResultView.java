package nextstep.ladder.view;

import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Person;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {

    private final static String RESULT_MESSAGE = "실행결과";
    private static final String EMPTY_WIDTH_LINE = "  ";

    private ResultView() {
    }

    private static String nameSpace(String name) {
        return IntStream
                .range(0, name.length() / 2)
                .mapToObj(i -> " ")
                .reduce((prev, next) -> prev + next)
                .orElseThrow();
    }

    private static void printName(List<Person> people) {
        people.forEach(person -> print(person.name() + EMPTY_WIDTH_LINE));
        println();
    }

    private static void printLine(String name, List<Line> lines) {
        lines.forEach(line -> println(nameSpace(name) + line.draw()));
    }

    public static void println() {
        println("");
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void printResult(Ladder ladder) {
        println(RESULT_MESSAGE);
        println();
        printName(ladder.people());
        String firstName = ladder.people().get(0).name();
        printLine(firstName, ladder.lines());
    }
}
