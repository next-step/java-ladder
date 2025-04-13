package ladder.view;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.User;

import static java.util.stream.Collectors.joining;

public class OutputView {
    private static final String LADDER_HORIZONTAL = "-----";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_PADDING = "    ";
    private static final String SPACES = "     ";
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";
    private static final String RESULT = "실행결과";

    public static void printLadderResult(Ladder ladder, List<User> users) {
        System.out.println(RESULT);
        newLine();
        printUsers(users);
        printLadder(ladder);
    }

    private static void printUsers(List<User> users) {
        users.stream()
            .map(User::getName)
            .map(OutputView::padNameToMaxLength)
            .collect(joining(SPACE))
            .lines()
            .forEach(System.out::print);

        newLine();
    }

    private static String padNameToMaxLength(String name) {
        if (name.length() < MAX_LENGTH) {
            return " ".repeat(MAX_LENGTH - name.length()) + name;
        }

        return name;
    }

    private static void newLine() {
        System.out.print(System.lineSeparator());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
            .stream()
            .map(line -> formatLadderLine(line.getLinks()))
            .forEach(System.out::println);
    }

    private static String formatLadderLine(List<Boolean> points) {
        return LADDER_PADDING + LADDER_VERTICAL +
            points.stream()
                .map(point -> point ? LADDER_HORIZONTAL : SPACES)
                .collect(joining(LADDER_VERTICAL)) +
            LADDER_VERTICAL;
    }
}
