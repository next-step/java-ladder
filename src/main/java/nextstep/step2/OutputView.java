package nextstep.step2;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과\n";
    private static final String INITIAL_EMPTY = "    ";
    private static final String PARTITION = "|";
    private static final String LAST_PARTITION = "|\n";
    private static final String LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String LINE_BREAKER = "\n";

    public static void draw(Ladder ladder, People people) {
        printPeople(people);
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadder().forEach(lines -> {
            print(INITIAL_EMPTY);
            printLines(lines);
            print(LAST_PARTITION);
        });
    }

    private static void printLines(Lines lines) {
        lines.getLines().forEach(line -> {
            printLine(line);
        });
    }

    private static void printPeople(People people) {
        print(RESULT_MESSAGE);
        people.getPeople()
                .forEach(person -> print(person.getName() + "  "));
        print(LINE_BREAKER);
    }

    private static void printLine(Line line) {
        print(PARTITION);
        if (line.isTrue()) {
            print(LINE);
        } else {
            print(EMPTY_LINE);
        }
    }

    private static void print(String message) {
        System.out.print(message);
    }
}
