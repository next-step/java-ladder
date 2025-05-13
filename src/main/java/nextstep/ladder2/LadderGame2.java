package nextstep.ladder2;

import nextstep.ladder2.domain.ladder.Ladder;
import nextstep.ladder2.domain.player.Player;
import nextstep.ladder2.domain.player.Players;
import nextstep.ladder2.domain.result.LadderResult;
import nextstep.ladder2.domain.result.MatchingResult;
import nextstep.ladder2.domain.reward.Rewards;
import nextstep.ladder2.view.InputView;
import nextstep.ladder2.view.ResultView;

public class LadderGame2 {
    public static void main(String[] args) {
        Players players = InputView.getPlayers();
        Rewards rewards = InputView.getRewards();

        if (players.count() != rewards.count()) {
            throw new IllegalArgumentException("플레이어와 보상은 개수가 같아야 합니다.");
        }

        int height = InputView.getHeight();

        Ladder ladder = new Ladder(players.count(), height);
        MatchingResult matchingResult = ladder.play();
        LadderResult ladderResult = matchingResult.map(players, rewards);

        ResultView.showLadder(ladder, players, rewards);
        while(true) {
            Player someone = InputView.getPlayerName();
            if(someone.name().equalsIgnoreCase("quit")) {
                break;
            }

            ResultView.rewardResult(someone, ladderResult);
        }
    }
}
