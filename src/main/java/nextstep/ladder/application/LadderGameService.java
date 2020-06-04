package nextstep.ladder.application;

import nextstep.ladder.domain.GameResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Rewards;

public class LadderGameService {
    public GameResults playGame(Players players, Ladder ladder, Rewards rewards) {
        ladder.playGameWithAllPlayers(players);
        return GameResults.create(players, rewards);
    }
}
