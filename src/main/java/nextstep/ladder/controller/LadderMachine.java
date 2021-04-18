package nextstep.ladder.controller;

import nextstep.ladder.domain.*;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;
import nextstep.ladder.view.dto.RewardsDto;

import java.util.List;

public class LadderMachine {

    private static final String ILLEGAL_PLAYER_MESSAGE = "없는 참가자 입니다.";
    private static final String ILLEGAL_REWARD_LENGTH_MESSAGE = "결과는 참가자 수와 다를 수 없습니다";

    private Ladder ladder;
    private Rewards rewards;

    public void run() {
        List<String> playerNames = InputView.getPlayerNames();
        Players players = Players.from(playerNames);
        List<String> rewards = InputView.getRewards();
        this.rewards = Rewards.from(rewards);
        validateRewards(players);
        Height height = InputView.getHeightOfLadder();
        this.ladder = Ladder.of(height, players);
        ResultView.showPlayers(players.readOnlyPlayerNames());
        ResultView.showLadder(ladder, this.rewards);
        showResult(players);
    }

    private void validateRewards(Players players) {
        if (players.countOfPerson() != rewards.countOfReward()) {
            throw new IllegalArgumentException(ILLEGAL_REWARD_LENGTH_MESSAGE);
        }
    }

    private void showResult(Players players) {
        Rewards reArrangeRewards = Rewards.of(rewards, ladder.allResult());
        RewardsDto rewardsDto = RewardsDto.of(players.readOnlyPlayerNames(), reArrangeRewards);
        Query query = InputView.getResultQuery();
        while (query.isNotEndQuery()) {
            validateQuery(players, query);
            ResultView.showResultOfPlayer(rewardsDto.findQueryResult(query));
            query = InputView.getResultQuery();
        }
        ResultView.showResultOfAll(rewardsDto);
    }

    private void validateQuery(Players players, Query query) {
        if (query.isNotEndQuery() && queryNotInPlayers(players, query)) {
            throw new IllegalArgumentException(ILLEGAL_PLAYER_MESSAGE);
        }
    }

    private boolean queryNotInPlayers(Players players, Query query) {
        Player queryPlayer = Player.from(query);
        return players.notIncludePlayer(queryPlayer);
    }
}
