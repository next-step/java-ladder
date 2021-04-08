package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.RewardsDto;

import java.util.List;

public class LadderMachine {

    private static final String ILLEGAL_PLAYER_MESSAGE = "없는 참가자 입니다.";
    private static final String GAME_END_QUERY = "all";

    private Ladder ladder;
    private Rewards rewards;

    public void run() {
        List<String> playerNames = InputView.getPlayerNames();
        Players players = Players.from(playerNames);
        List<String> rewards = InputView.getRewards();
        this.rewards = Rewards.from(rewards);
        Height height = InputView.getHeightOfLadder();
        this.ladder = new Ladder(height, players.countOfPerson());
        ResultView.showPlayers(players.readOnlyPlayerNames());
        ResultView.showLadder(ladder.readOnlyLadder(), this.rewards);
        showResult(players);
    }

    private void showResult(Players players) {
        boolean isRunning = true;
        while (isRunning) {
            Player player = InputView.getPlayer();
            validatePlayer(players, player);
            isRunning = findResultOrEnd(players, player);
        }
    }

    private void validatePlayer(Players players, Player player) {
        if (!player.getName().equals(GAME_END_QUERY) && players.notIncludePlayer(player)) {
            throw new IllegalArgumentException(ILLEGAL_PLAYER_MESSAGE);
        }
    }

    private boolean findResultOrEnd(Players players, Player player) {
        if (GAME_END_QUERY.equals(player.getName())) {
            Rewards reArrangeRewards = Rewards.of(rewards, ladder.positionOfAllResult());
            ResultView.showResultOfAll(RewardsDto.of(players.readOnlyPlayerNames(), reArrangeRewards));
            return false;
        }
        int startPosition = players.position(player);
        ResultView.showResultOfPlayer(rewards.positionOfReward(ladder.positionOfResult(startPosition)));
        return true;
    }
}
