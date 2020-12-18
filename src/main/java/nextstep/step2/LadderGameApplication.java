package nextstep.step2;

import nextstep.step2.VO.Ladder;
import nextstep.step2.VO.Users;
import nextstep.step2.view.InputView;
import nextstep.step2.view.OutputView;

public class LadderGameApplication {
    public static void main(String[] args) {
        Users users = InputView.inputUsers();

        int ladderHeight = InputView.inputHeight();

        Ladder ladder = new Ladder(users.getUserListSize(), ladderHeight);

        OutputView.printUsers(users);
        OutputView.printLadder(ladder);
    }
}
