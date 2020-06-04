package ladder.domain.ladder.shape;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.PillarCount;
import ladder.domain.player.Players;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class LadderShapeInfo {

    private final Players players;
    private final Height height;

    private LadderShapeInfo(final Players players, final Height height) {
        validate(players, height);
        this.players = players;
        this.height = height;
    }

    public static LadderShapeInfo valueOf(final Players players, final Height height) {
        return new LadderShapeInfo(players, height);
    }

    private void validate(final Players players, final Height height) {
        if (Objects.isNull(players) || Objects.isNull(height)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public PillarCount getWidth() {
        return PillarCount.of(players.count());
    }

    public Height getHeight() {
        return height;
    }

    public Players getPlayers() {
        return players;
    }
}
