package ladder.view;


import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.user.User;

import java.util.List;

public class LadderOutput {
    private static final String LADDER_DRAW_RESULT = "실행결과";
    private static final String DIGITS = "6";

    public static void drawLadderGame(List<User> users, List<Lines> ladder) {
        System.out.println(LADDER_DRAW_RESULT);
        drawUsers(users);
        drawLadder(ladder);
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

}
