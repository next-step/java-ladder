package ladder;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Users;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderGame {
    public static void main(String...args) {
        InputView inputView = new InputView();

        Users users = new Users(inputView.joinUser());
        Height height = new Height(inputView.ladderHeight());

        ResultView.resultLadder(users.getUsers(), new Ladder(users.getUserCount(), height));
    }
}
