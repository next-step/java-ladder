package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import nextstep.ladder.domain.UserLadderResult;

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

    public static void printUserResult(UserLadderResult userLadderResult, String userName) {
        if ("all".equals(userName)) {
            printAllUserResult(userLadderResult);
            return;
        }
        Result result = userLadderResult.findUserResult(userName);
        System.out.println("실행결과");
        System.out.println(userName + " : " + result);
    }

    private static void printAllUserResult(UserLadderResult userLadderResult) {
        System.out.println("실행결과");

        userLadderResult.findAllUser().stream()
                .forEach(user -> System.out.println(user.toString() + " : " + userLadderResult.findUserResult(user.toString())));
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

