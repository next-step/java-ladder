package ladder.view;

import ladder.domain.Lines;
import ladder.domain.Users;

import static ladder.utils.Constants.MSG_RESULT_PLAY;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void resultLadder() {
        System.out.println();
        System.out.println(MSG_RESULT_PLAY);
        System.out.println();
    }

    public static void drawLadderUsers(Users users) {
        System.out.println(users.getUserNames());
    }

    public static void drawLadderLines(Lines lines) {
        lines.getLines().stream()
                .forEach(line -> System.out.println(line.getResultLine()));
    }
}
