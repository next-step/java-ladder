package ladder.controller;

import ladder.domain.RewardDirector;
import ladder.domain.Rewards;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

import java.util.stream.IntStream;

public class LadderGame {

    private Players players;
    private Rewards rewards;
    private Ladder ladder;

    public void initData() {
        initGameData();
    }

    public void showResult() {
        showRewardResult();
    }

    private void initGameData() {
        players = new Players(InputView.inputPlayerNames());

        rewards = new Rewards(InputView.inputResultValue(), players.getPlayerNum());

        int ladderHeight = InputView.inputLadderHeight();
        ladder = Ladder.createLadder(players.getPlayerNum(), ladderHeight);

        ResultView.showLadderResult(players, ladder, rewards);
    }

    private void showRewardResult() {
        while (true) {
            searchRewardForPlayers();
        }
    }

    private void searchRewardForPlayers() {
        int playerPosition = players.getPositionInLadder(InputView.inputResultPlayer());

        if (playerPosition == players.getPlayerNum()) {
            int playerNum = players.getPlayerNum();
            ResultView.showRewardResultMessage();
            searchRewardAllPlayers(playerNum);
            return;
        }

        ResultView.showRewardResultMessage();
        showRewardOnlyPlayer(ladder, playerPosition);
    }

    private void searchRewardAllPlayers(int playerNum) {
        IntStream.range(0, playerNum).forEach(i -> {
            int reward = RewardDirector.searchReward(ladder, i);
            ResultView.showRewardOnePlayer(rewards, reward, players.getPlayers().get(i));
        });
    }

    private void showRewardOnlyPlayer(Ladder ladder, int playerPosition) {
        int reward = RewardDirector.searchReward(ladder, playerPosition);
        ResultView.showRewardOnePlayer(rewards, reward);
    }
}
