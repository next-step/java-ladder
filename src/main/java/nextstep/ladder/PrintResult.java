package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class PrintResult {
    private static final int WIDTH = 5;
    private static String WHITESPACE_DELIMITER = StringUtil.repeat(" ", WIDTH);
    private static String BAR_DELIMITER = "|";
    private static String DASH_DELIMITER = StringUtil.repeat("-", WIDTH);


    public static void printUsers(List<User> users) {
        users.stream()
                .forEach(user -> System.out.print(String.format("%5s ", user.getUserName())));
    }

    public static void println() {
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(line -> line.getPoints())
                .map(PrintResult::convertPointsToString)
                .forEach(System.out::println);
    }

    public static String convertPointsToString(List<Point> points) {

        return points.stream().map(p -> {
            if (p.isLeft()) {
                return DASH_DELIMITER;
            }
            return WHITESPACE_DELIMITER;
        }).collect(Collectors.joining(BAR_DELIMITER, "", BAR_DELIMITER));
    }
}
