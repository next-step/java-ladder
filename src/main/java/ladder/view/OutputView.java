package ladder.view;

import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.Users;

public class OutputView {
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_NONE = "     ";

    public static void printLadderResult(Users users, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        printUserNames(users);
        printLadder(ladder);
    }

    private static void printUserNames(Users users) {
        String name = users.getUsers().stream()
                .map(user -> String.format("%6s", user.getName()))
                .collect(Collectors.joining(""));
        System.out.println(name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> {
            line.getPoints().forEach(OutputView::printLine);
            System.out.println();
        });
    }

    private static void printLine(boolean hasLine) {
        if (hasLine) {
            System.out.print(LADDER_HORIZON + LADDER_VERTICAL);
            return;
        }
        System.out.print(LADDER_NONE + LADDER_VERTICAL);
    }
}
