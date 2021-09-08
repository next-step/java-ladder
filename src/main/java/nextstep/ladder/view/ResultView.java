package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {

    private static final String START_LADDER = "      |";
    private static final String EXIST_MIDDLE_LADDER = "-----|";
    private static final String EMPTY_MIDDLE_LADDER = "     |";
    private static final String ALL_USER = "all";

    public static void result(List<LadderLine> ladderLines, List<User> user, List<Result> results) {
        printUsers(user);
        ladderLines.stream().forEach((line) -> printLadder(line.getPoints()));
        printResults(results);
    }

    public static void printUserResult(UserLadderResult userLadderResult, String userName) {
        if (ALL_USER.equals(userName)) {
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

    private static void printLadder(List<Point> points) {
        System.out.print(START_LADDER);
        points.stream().limit(points.size() - Position.OFFSET).forEach(ResultView::printMiddleLadder);
        System.out.println();
    }

    private static void printMiddleLadder(Point point) {
        if (point.isConnected()) {
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

