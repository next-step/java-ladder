package ladder.view;


import ladder.domain.line.Lines;
import ladder.domain.result.LadderResult;
import ladder.domain.result.LadderResults;
import ladder.domain.user.User;
import ladder.domain.user.UserResult;

import java.util.List;

public class LadderOutput {
    private static final String LADDER_DRAW_RESULT = "실행결과";
    private static final String DIGITS = "6";

    public static void drawLadderGame(List<User> users, List<Lines> ladder, List<LadderResult> results) {
        System.out.println(LADDER_DRAW_RESULT);
        drawUsers(users);
        drawLadder(ladder);
        drawLadderResult(results);
    }

    private static void drawLadderResult(List<LadderResult> results) {
        System.out.println();
        for (LadderResult result : results) {
            System.out.print(String.format("%" + DIGITS + "s", result.showResult()));
        }
        System.out.println();
    }

    public static void drawLadder(List<Lines> ladder) {
        for (Lines lines : ladder) {
            System.out.println();
            for (String line : lines.showLines()) {
                System.out.print(String.format("%" + DIGITS + "s", line));
            }
        }
    }

    public static void drawUsers(List<User> users) {
        for (User user : users) {
            System.out.print(String.format("%" + DIGITS + "s", user.userName()));
        }
    }

    public static void showLadderResult(LadderResults ladderResult, UserResult userResult) {
        System.out.println(userResult.name() + " : " + ladderResult.showResult(userResult.position()));
    }

    public static void showLadderResultAll(LadderResults ladderResults, List<UserResult> userResults) {
        for (UserResult userResult : userResults) {
            showLadderResult(ladderResults, userResult);
        }
    }
}
