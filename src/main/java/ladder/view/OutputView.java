package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Users;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void userNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void ladderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    }

    public static void result(Users users, Ladder ladder) {
        System.out.println("\n실행결과");
        System.out.println(users.usersName());
        for (Line line: ladder.getColumns()) {
            System.out.println(line.lineToDash());
        }
    }
}
