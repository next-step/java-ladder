package nextstep.ladder.view;

import nextstep.ladder.domain.line.LadderConstructionStatus;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.user.Users;

public class Output {

    private static final String HORIZONTAL_LINE = "-----|";
    private static final String EMPTY_SPACE = "     |";
    private static final String VERTICAL_LINE = "|";
    private static final String RESULT_HEADER = "실행결과";

    private Output() {
    }

    public static void printResult(Users users, Lines lines) {
        System.out.println(RESULT_HEADER);
        printUserNames(users);
        printLadderLines(lines);
    }

    private static void printUserNames(Users users) {
        users.getUsers()
            .forEach(user -> System.out.print(String.format("%6s", user.getUserName())));
        System.out.println();
    }

    private static void printLadderLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(String.format("%6s", VERTICAL_LINE));
            printLineStatus(line);
            System.out.println();
        }
    }

    private static void printLineStatus(Line line) {
        for (LadderConstructionStatus status : line.getPoints()) {
            System.out.print(String.format("%6s", status.isLadderConstructionStatusFalse()
                ? EMPTY_SPACE
                : HORIZONTAL_LINE));
        }
    }
}
