package camp.nextstep.edu.rebellion.refactoring;

import camp.nextstep.edu.rebellion.domain.player.Players;
import camp.nextstep.edu.rebellion.domain.reward.Rewards;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;

    public LadderGame(Players players, Rewards rewards, int rows) {
        this.players = players;
        this.rewards = rewards;
        this.ladder = new Ladder(rows, players.getCountOfPlayers());
    }
}
