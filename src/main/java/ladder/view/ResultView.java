package ladder.view;

import ladder.domain.Ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String POINT_LINE = "|";
    private static final String CURRENT_TRUE = "-----";
    private static final String CURRENT_FALSE = "     ";
    private static final String SPACE = "   ";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLadder(Ladder ladder) {
        printNames(ladder);
        printLines(ladder);
        printResultList(ladder);
    }

    public static void printResult(Ladder ladder, String playerName) {
        System.out.println(RESULT_MESSAGE);
        Map<String, String> result = ladder.result(playerName);
        result.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void printNames(Ladder ladder) {
        System.out.println(RESULT_MESSAGE);

        String nameList = ladder.names().stream()
                .map(name -> name + SPACE)
                .collect(Collectors.joining());
        System.out.println(nameList);
    }

    private static void printLines(Ladder ladder) {
        ladder.lines()
                .forEach(line -> System.out.println(line.currentPoints()
                        .stream()
                        .map(current -> current ? POINT_LINE + CURRENT_TRUE : POINT_LINE + CURRENT_FALSE)
                        .collect(Collectors.joining()))
                );
    }

    private static void printResultList(Ladder ladder) {
        String resultList = ladder.results().stream()
                .map(result -> result + SPACE)
                .collect(Collectors.joining());
        System.out.println(resultList);
    }
}
