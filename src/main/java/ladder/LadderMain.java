package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderEdge;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.Map;

public class LadderMain {
    public static void main(String[] args) {
        Players players = Players.valueOf(InputView.getPlayers());
        Rewards rewards = Rewards.valueOf(InputView.getRewards());
        LadderEdge ladderEdge = new LadderEdge(players, rewards);

        int height = InputView.getLadderHeight();
        Ladder ladder = Ladder.valueOf(ladderEdge.playerSize(), height);
        ResultView.printLadder(ladder, ladderEdge);

        Map<String, String> gameResult = ladderEdge.gameResult(ladder);
        String findResult = InputView.findResult();

        ResultView.printResult(findResult, gameResult);
    }
}
