package ladder.domain.dto;

import ladder.domain.PlayersAndPrizes;
import ladder.domain.ladder.Ladder2;

import java.util.List;

public class LadderShapeResult2 {

    private final PlayersAndPrizes playersAndPrizes;
    private final List<StairDto2> stairDtos;

    private LadderShapeResult2(final PlayersAndPrizes playersAndPrizes, final List<StairDto2> stairDtos) {
        this.playersAndPrizes = playersAndPrizes;
        this.stairDtos = stairDtos;
    }

    public static LadderShapeResult2 of(final PlayersAndPrizes playersAndPrizes, final Ladder2 ladder) {
        return new LadderShapeResult2(playersAndPrizes, StairDto2.from(ladder));
    }

    public List<String> getPlayerNames() {
        return playersAndPrizes.getPlayerNames();
    }

    public List<String> getPrizeNames() {
        return playersAndPrizes.getPrizeNames();
    }

    public List<StairDto2> getStairDtos() {
        return stairDtos;
    }
}
