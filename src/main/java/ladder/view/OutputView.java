package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Users;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String RESULT_TITLE = "\n실행결과\n";
    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";

    public static void printNames(Users users) {
        System.out.println(RESULT_TITLE);
        users.getNames().stream()
                        .forEach(name -> System.out.printf("%6s", name.getName()));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLadder();

        IntStream.range(0, lines.get(0).getPoints().size()).mapToObj(x -> OutputView.generateStringLine(x, lines))
                 .forEach(System.out::println);
    }

    public static String generateStringLine(int x, List<Line> lines) {
        return IntStream.range(0, lines.size())
                        .mapToObj(y -> lines.get(y).getPoints().get(x) ? LINE_TRUE : LINE_FALSE)
                        .collect(Collectors.joining(LINE_DELIMITER)) + "|";

    }
}
