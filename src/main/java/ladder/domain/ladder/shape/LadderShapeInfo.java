package ladder.domain.ladder.shape;

import ladder.domain.PlayersAndPrizes;
import ladder.exception.ErrorMessage;

import java.util.Objects;

public class LadderShapeInfo {

    private final PlayersAndPrizes playersAndPrizes;
    private final Height height;

    private LadderShapeInfo(final PlayersAndPrizes playersAndPrizes, final Height height) {
        validate(playersAndPrizes, height);
        this.playersAndPrizes = playersAndPrizes;
        this.height = height;
    }

    public static LadderShapeInfo valueOf(final PlayersAndPrizes playersAndPrizes, final Height height) {
        return new LadderShapeInfo(playersAndPrizes, height);
    }

    private void validate(final PlayersAndPrizes playersAndPrizes, final Height height) {
        if (Objects.isNull(playersAndPrizes) || Objects.isNull(height)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public PillarCount getWidth() {
        return PillarCount.of(playersAndPrizes.getPlayersCount());
    }

    public int getHeight() {
        return height.getValue();
    }

    public PlayersAndPrizes getPlayersAndPrizes() {
        return playersAndPrizes;
    }
}
