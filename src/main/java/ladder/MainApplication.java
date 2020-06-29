package ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.line.Height;
import ladder.domain.player.Players;
import ladder.domain.result.MatchResult;
import ladder.domain.result.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;

public class MainApplication {

    public static void main(String[] args) {
        Players players = InputView.readPlayers();
        Rewards rewards = InputView.readRewards(players);
        Height height = InputView.readHeight();

        Ladder ladder = Ladder.create(players, height);

        ResultView.printPlayers(players);
        ResultView.printLines(ladder.getLines());
        ResultView.printRewards(rewards);

        MatchResult matchResult = MatchResult.create(ladder, rewards);
        ResultView.printMatchResult(InputView.readMatchPlayer(), matchResult);
        ResultView.printMatchResult(InputView.readMatchPlayer(), matchResult);
    }
}
