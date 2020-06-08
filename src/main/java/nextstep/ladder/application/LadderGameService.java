package nextstep.ladder.application;

import nextstep.ladder.domain.gameresult.GameResults;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;

public class LadderGameService {
    public GameResults playGame(Players players, Ladder ladder, Rewards rewards) {
        ladder.playGameWithAllPlayers(players);
        return GameResults.create(players, rewards);
    }
}
