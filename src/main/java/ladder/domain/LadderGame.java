package ladder.domain;

import ladder.domain.dto.LadderShapeResult;
import ladder.domain.dto.StairDto;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.player.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    private LadderGame(final Players players, final Height height) {
        this.players = players;
        this.ladder = Ladder.of(height, players.count());
    }

    public static LadderGame of(final Players players, final Height height) {
        return new LadderGame(players, height);
    }

    public LadderShapeResult play() {
        return LadderShapeResult.of(players.getNames(), StairDto.from(ladder));
    }
}
