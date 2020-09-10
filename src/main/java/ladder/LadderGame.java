package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String...args) {
        Users users = new Users(InputView.joinUser());
        Height height = new Height(InputView.ladderHeight());

        ResultView.resultLadder(users.getUsers(), new Ladder(users.getUserCount(), height));
    }
}
