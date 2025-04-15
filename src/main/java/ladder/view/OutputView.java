package ladder.view;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.LadderSimulator;
import ladder.domain.UserResult;
import ladder.domain.User;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class OutputView {
    private static final String DELIMITER = " : ";
    private static final String LADDER_HORIZONTAL = "-----";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_PADDING = "    ";
    private static final String SPACES = "     ";
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";
    private static final String RESULT = "실행결과";
    private static final String ALL = "all";

    public static void printLadderResult(Ladder ladder, List<User> users, List<String> results) {
        System.out.println(RESULT);
        newLine();
        printUsers(users);
        printLadder(ladder);
        printResult(results);
    }

    private static void printUsers(List<User> users) {
        users.stream()
            .map(User::getName)
            .map(OutputView::padToMaxLength)
            .collect(joining(SPACE))
            .lines()
            .forEach(System.out::print);

        newLine();
    }

    private static String padToMaxLength(String name) {
        if (name.length() < MAX_LENGTH) {
            return " ".repeat(MAX_LENGTH - name.length()) + name;
        }

        return name;
    }

    private static void newLine() {
        System.out.print(lineSeparator());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines()
            .stream()
            .map(line -> formatLadderLine(line.getLinks()))
            .forEach(System.out::println);
    }

    private static void printResult(List<String> results) {
        System.out.println(results.stream()
            .map(OutputView::padToMaxLength)
            .collect(joining(SPACE)));
    }

    private static String formatLadderLine(List<Boolean> points) {
        return LADDER_PADDING + LADDER_VERTICAL +
            points.stream()
                .map(point -> point ? LADDER_HORIZONTAL : SPACES)
                .collect(joining(LADDER_VERTICAL)) +
            LADDER_VERTICAL;
    }

    public static void outputLadderResult(LadderSimulator simulator, InputView inputView) {
        LadderResult ladderResult = simulator.getResults();

        while(true) {
            String userName = inputView.inputPlayerResult();

            if (userName.equals(ALL)) {
                OutputView.printResultAll(ladderResult.getSortedResults());
                break;
            }

            OutputView.printUserResult(ladderResult.getResult(userName));
        }
    }

    private static void printUserResult(String result) {
        System.out.println(RESULT);
        System.out.println(result);
    }

    private static void printResultAll(List<UserResult> results) {
        System.out.println(RESULT);
        System.out.println(results.stream()
            .map(result -> result.getName() + DELIMITER + result.getResult())
            .collect(joining(lineSeparator())));
    }
}
