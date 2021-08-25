package ladder.view;

import ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String LADDER_TITLE = "\n사다리 결과\n";
    private static final String RESULT_TITLE = "\n실행 결과\n";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printNames(Users users) {
        System.out.println(LADDER_TITLE);
        users.getNames().stream().forEach(name -> System.out.printf("%6s", name.getName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
              .stream()
              .map(OutputView::generateLine)
              .forEach(System.out::println);
    }

    public static void printItems(WinningItems winningItems) {
        winningItems.getWinningItems().stream().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static String generateLine(Line line) {
        return line.getPoints()
                   .stream()
                   .map(flag -> flag ? LINE_TRUE : LINE_FALSE)
                   .collect(Collectors.joining(LINE_DELIMITER)) + "|";

    }

    public static void printResult(String name, Map<String, String> result) {
        System.out.println(RESULT_TITLE);
        if ("all".equals(name)) {
            result.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
            return;
        }
        System.out.println(result.get(name));
    }

}
