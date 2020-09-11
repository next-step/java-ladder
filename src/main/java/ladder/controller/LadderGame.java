package ladder.controller;

import ladder.domain.line.Height;
import ladder.domain.line.Ladder;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResults;
import ladder.domain.reward.Rewards;
import ladder.domain.strategy.RandomPointStrategy;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

public class LadderGame {
    private static final String ALL_PLAYERS = "all";

    public void start() {
        Players players = inputPlayers();
        Rewards rewards = inputReward(players.size());
        Height height = inputHeight();

        Ladder ladder = Ladder.of(players.size(), height, new RandomPointStrategy());
        printLadderResult(players, ladder);
        printRewards(rewards);

        LadderResults ladderResults = LadderResults.of(players, rewards, ladder);

        while (shouldContinue(ladderResults));
    }

    private boolean shouldContinue(LadderResults ladderResults) {
        String playerName = inputResultPlayerName();

        if (ALL_PLAYERS.equals(playerName)) {
            printResultAll(ladderResults);
            return false;
        }

        printResultByName(playerName, ladderResults);
        return true;
    }
}
