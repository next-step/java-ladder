package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    public static void main(String...args) {
        InputView inputView = new InputView();

        Users users = new Users(inputView.joinUser());
        Rewards rewards = new Rewards(inputView.inputGameResult(), users.getUserCount());
        Height height = new Height(inputView.ladderHeight());

        Ladder ladder = new Ladder(users.getUserCount(), height);
        ResultView.resultLadderGame(users.getUsers(), ladder, rewards);

        LadderResult ladderResult = new LadderResult(users, rewards, ladder);
        Result result = ladderResult.downLadder();

        ResultView.printWhoGetPrize(inputView.seeResult(), result);
    }
}
