package ladder.view;

import ladder.domain.Ladder;

import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POINT_LINE = "|";
    private static final String CURRENT_TRUE = "-----";
    private static final String CURRENT_FALSE = "     ";
    private static final String NAME_SPACE = "  ";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadder(Ladder ladder) {
        printNames(ladder);
        printLines(ladder);
    }

    private static void printNames(Ladder ladder) {
        System.out.println(ladder.names().stream()
                .map(name -> name + NAME_SPACE)
                .collect(Collectors.joining())
        );
    }

    private static void printLines(Ladder ladder) {
        ladder.lines()
                .forEach(line -> System.out.println(line.currentPoints()
                        .stream()
                        .map(current -> current ? POINT_LINE + CURRENT_TRUE : POINT_LINE + CURRENT_FALSE)
                        .collect(Collectors.joining()))
                );
    }
}
