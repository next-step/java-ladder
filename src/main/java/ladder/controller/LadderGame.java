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

    public static final String ALL_KEYWORD = "all";

    public void start() {
        Players players = inputPlayers();
        Rewards rewards = inputReward(players.size());
        Height height = inputHeight();

        Ladder ladder = Ladder.of(players, height, new RandomPointStrategy());
        printLadderResult(players, ladder);
        printRewards(rewards);

        LadderResults ladderResults = LadderResults.of(players, rewards, ladder);

        String playerName = "";
        while (!ALL_KEYWORD.equals(playerName)) {
            playerName = inputResultPlayerName();
            printResults(playerName, ladderResults);
        }
    }
}
