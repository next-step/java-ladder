package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderMain {
    public static void main(String[] args) {
        Players players = Players.valueOf(InputView.getPlayers());
        Rewards rewards = Rewards.valueOf(InputView.getRewards());
        LadderEdge ladderEdge = new LadderEdge(players, rewards);

        int height = InputView.getLadderHeight();
        Ladder ladder = Ladder.valueOf(ladderEdge.playerSize(), height);
        ResultView.printLadder(ladder, ladderEdge);

        LadderGame ladderGame = LadderGame.valueOf(ladderEdge, ladder);
        String findResult = InputView.findResult();

        ResultView.printResult(findResult, ladderGame);
    }
}
