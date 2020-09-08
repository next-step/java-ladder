package ladder.controller;

import ladder.domain.player.Players;
import ladder.domain.result.GameResults;
import ladder.domain.reward.Rewards;
import ladder.domain.rule.RandomDrawRule;
import ladder.game.Ladder;
import ladder.game.LadderGame;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void start() {
        Players players = Players.of(InputView.inputPlayerNames());
        Rewards rewards = Rewards.of(InputView.inputRewards());

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(InputView.inputRowCount())
                .build();

        Ladder ladder = ladderGame.makeLadder(new RandomDrawRule());

        ResultView.printAll(players, rewards, ladder);

        ResultView.printGameResults(GameResults.builder()
                .rewards(rewards)
                .positions(ladderGame.run(InputView.inputResultTarget()))
                .build());
    }
}
