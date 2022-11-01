package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    private static LadderController ladderController;
    public static LadderController getInstance() {
        if (ladderController == null) {
            ladderController = new LadderController();
        }

        return ladderController;
    }

    public void run() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Users users = Users.from(InputView.getNames());

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Ladder ladder = Ladder.of(users.getUserCount(), InputView.getHeight());

        OutputView.printLadder(users.getUserList(), ladder.getLines());
    }
}
