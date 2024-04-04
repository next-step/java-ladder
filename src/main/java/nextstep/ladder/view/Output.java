package nextstep.ladder.view;

import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.line.Point;
import nextstep.ladder.domain.user.Users;

public class Output {

    private static final String HORIZONTAL_LINE = "-----|";
    private static final String EMPTY_SPACE = "     |";
    private static final String VERTICAL_LINE = "|";
    private static final String RESULT_HEADER = "실행결과";
    private static final String OUT_PUT_FORMAT = "%6s";


    private Output() {
    }

    public static void printResult(Users users, Lines lines) {
        System.out.println(RESULT_HEADER);
        printUserNames(users);
        printLadderLines(lines);
    }

    private static void printUserNames(Users users) {
        users.getUsers()
            .forEach(user -> System.out.print(String.format(OUT_PUT_FORMAT, user.getUserName())));
        System.out.println();
    }

    private static void printLadderLines(Lines lines) {
        for (Line line : lines.getLines()) {
            System.out.print(String.format(OUT_PUT_FORMAT, VERTICAL_LINE));
            printLineStatus(line);
            System.out.println();
        }
    }

    private static void printLineStatus(Line line) {
        for (Point status : line.getPoints()) {
            System.out.print(String.format(OUT_PUT_FORMAT, status.isPointFalse()
                ? EMPTY_SPACE
                : HORIZONTAL_LINE));
        }
    }

    private static void printIndividualResults(LadderResult ladderResult) {

    }
}
