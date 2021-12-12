package ladder.view;

import ladder.domain.Lines;
import ladder.domain.Users;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void resultLadder() {
        System.out.println("실행결과");
    }

    public static void drawLadder(Users users, Lines lines) {
        System.out.println(users.getUserNames());
    }
}
