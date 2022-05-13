package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Users;

public class ResultView {
    private static final String RESULT_TITLE_MESSAGE = "\r\n실행결과";
    private static final String FIRST_HEIGHT = "    |";
    private static final String EMPTY_HORIZONTAL = "     |";
    private static final String HORIZONTAL = "-----|";

    public static void printResult(Users users, Ladder ladder) {
        System.out.println(RESULT_TITLE_MESSAGE);
        printUserNames(users);
        printLadder(ladder);
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.print(FIRST_HEIGHT);
            printLine(line);
            System.out.println();
        }
    }

    private static void printLine(Line line) {
        for (int i = 0; i < line.getPoints().size(); i++) {
            printPoint(line, i);
        }
    }

    private static void printPoint(Line line, int i) {
        if (line.getPoints().get(i)) {
            System.out.print(HORIZONTAL);
            return;
        }
        System.out.print(EMPTY_HORIZONTAL);
    }

    private static void printUserNames(Users users) {
        System.out.println();
        for (String name : users.getUserNames()) {
            System.out.print(name + "    ");
        }
        System.out.println();
    }
}
