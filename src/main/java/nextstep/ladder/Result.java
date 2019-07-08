package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    private static final int WIDTH = 5;
    private static String WHITESPACE_DELIMITER = StringUtil.repeat(" ", WIDTH);
    private static String BAR_DELIMITER = "|";
    private static String DASH_DELIMITER = StringUtil.repeat("-", WIDTH);


    public static void printUsers(List<User> users) {
        users.stream()
                .forEach(user -> System.out.print(String.format("%5s ", user.getUserName())));
    }

    public static void printInputResult(List<String> results) {
        results.stream()
                .forEach(result -> System.out.print(String.format("%5s ", result)));
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines()
                .stream()
                .map(Line::getPoints)
                .map(Result::convertPointsToString)
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

    public static void printAllResult(Ladder ladder, List<User> users, List<String> results) {
        for (int i = 0; i < users.size(); i++) {
            printResult(ladder.getLines(), users, results, i);
        }
    }

    public static void printResult(List<Line> lines, List<User> users, List<String> results, int index) {
        int lastPosition = getLastIndexInLine(lines, index);
        System.out.println(users.get(index).getUserName() + ": " + results.get(lastPosition));
    }

    public static int getLastIndexInLine(List<Line> lines, int index) {
        int position = index;

        for (Line line : lines) {
            position = getNextIndex(line.getPoints(), position);
        }
        return position;
    }

    public static int getNextIndex(List<Point> points, int index) {
        return points.get(index).move();
    }
}
