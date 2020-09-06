package ladder.controller;

import ladder.domain.*;
import ladder.domain.rule.RandomDrawRule;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    public void start() {
        Players players = Players.of(InputView.inputPlayerNames());
        Rewards rewards = Rewards.builder().rewardInput(InputView.inputRewards())
                .countOfPlayers(players.getCountOfPlayers())
                .build();

        LadderGame ladderGame = LadderGame.builder()
                .players(players)
                .rows(InputView.inputRowCount())
                .build();
        Ladder ladder = ladderGame.makeLadder(new RandomDrawRule());

        LadderResult ladderResult = ladderGame.run();
        GameResult gameResult = ladderResult.mappingResult(players, rewards);

        ResultView.printPlayers(players);
        ResultView.printLadder(ladder);
        ResultView.printRewards(rewards);
        ResultView.printGameResult(InputView.inputResultTarget(), gameResult);
    }
}
