package nextstep.ladder.domain.game;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.reward.Rewards;

public class LadderGame {
    private Players players;
    private Ladder ladder;

    private LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderGame readyLadderGame(Players players, Ladder ladder) {
        return new LadderGame(players, ladder);
    }

    public GameResults playGame(Rewards rewards) {
        ladder.playGameWithAllPlayers(players);
        return GameResults.create(players, rewards);
    }
}
