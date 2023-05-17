package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Users;

public class OutputView {

    public static void afterGame() {
        System.out.println("실행 결과");
    }

    public static void display(Users users, Ladder ladder) {
        System.out.println(users.status());
        System.out.println(ladder.status());
    }
}
