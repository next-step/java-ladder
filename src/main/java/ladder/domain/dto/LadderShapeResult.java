package ladder.domain.dto;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.ladder.Ladder;

import java.util.List;

public class LadderShapeResult {

    private final PlayersAndPrizes playersAndPrizes;
    private final List<StairDto> stairDtos;

    private LadderShapeResult(final PlayersAndPrizes playersAndPrizes, final List<StairDto> stairDtos) {
        this.playersAndPrizes = playersAndPrizes;
        this.stairDtos = stairDtos;
    }

    public static LadderShapeResult of(final PlayersAndPrizes playersAndPrizes, final Ladder ladder) {
        return new LadderShapeResult(playersAndPrizes, StairDto.from(ladder));
    }

    public List<String> getPlayerNames() {
        return playersAndPrizes.getPlayerNames();
    }

    public List<String> getPrizeNames() {
        return playersAndPrizes.getPrizeNames();
    }

    public List<StairDto> getStairDtos() {
        return stairDtos;
    }
}
