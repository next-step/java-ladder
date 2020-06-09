package ladder.domain.ladder.shape;

import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class LadderShapeInfo {

    private final Players players;
    private final Prizes prizes;
    private final Height height;

    private LadderShapeInfo(final Players players, final Prizes prizes, final Height height) {
        validate(players, prizes, height);
        this.players = players;
        this.prizes = prizes;
        this.height = height;
    }

    public static LadderShapeInfo valueOf(final Players players, final Prizes prizes, final Height height) {
        return new LadderShapeInfo(players, prizes, height);
    }

    private void validate(final Players players, final Prizes prizes, final Height height) {
        if (Objects.isNull(players) || Objects.isNull(prizes) || Objects.isNull(height)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
        if (players.count() != prizes.count()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHED_VALUE);
        }
    }

    public PillarCount getWidth() {
        return PillarCount.of(players.count());
    }

    public int getHeight() {
        return height.getValue();
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
