package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;

import java.util.List;

public class ResultView {

    private static final String START_LADDER = "      |";
    private static final String EXIST_MIDDLE_LADDER = "-----|";
    private static final String EMPTY_MIDDLE_LADDER = "     |";

    public static void result(List<Line> ladder, List<User> user, List<Result> results) {
        printUsers(user);
        ladder.stream().forEach((line) -> printLadder(line.getPoints()));
        printResults(results);
    }

    private static void printLadder(List<Boolean> existPoints) {
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

    private static void printUsers(List<User> users) {
        users.stream().forEach(user -> System.out.printf("%6s", user));
        System.out.println();
    }

    private static void printResults(List<Result> results) {
        results.stream().forEach(result -> System.out.printf("%6s", result));
        System.out.println();
    }
}

