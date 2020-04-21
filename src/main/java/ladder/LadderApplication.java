package ladder;

import ladder.domain.LadderGame;
import ladder.domain.User;
import ladder.ui.InputView;
import ladder.ui.ResultView;

import java.util.List;

public class LadderApplication {
    public static void main(String[] args) {
        List<User> users = InputView.inputJoinUsers();
        int ladderMaxHeight = InputView.inputLadderMaxHeight();
        LadderGame ladderGame = new LadderGame(users, ladderMaxHeight);

        ResultView.printResult(users, ladderGame.getLadder());
    }
}
