package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Users;

import java.util.ArrayList;

public class ResultView {

    private static final String START_LADDER = "      |";
    private static final String EXIST_MIDDLE_LADDER = "-----|";
    private static final String EMPTY_MIDDLE_LADDER = "     |";

    public static void result(ArrayList<Line> ladder, Users users) {
        printUsers(users);
        ladder.stream().forEach((line) -> printLadder(line.getPoints()));
    }

    private static void printLadder(ArrayList<Boolean> existPoints) {
        System.out.print(START_LADDER);
        existPoints.stream().forEach(ResultView::printMiddleLadder);
        System.out.println();
    }

    private static void printMiddleLadder(Boolean isExistPoint) {
        if (isExistPoint) {
            System.out.print(EXIST_MIDDLE_LADDER);
            return;
        }
        System.out.print(EMPTY_MIDDLE_LADDER);
    }

    private static void printUsers(Users users) {
        users.getValue().stream().forEach(user -> System.out.printf("%6s", user));
        System.out.println();
    }
}

