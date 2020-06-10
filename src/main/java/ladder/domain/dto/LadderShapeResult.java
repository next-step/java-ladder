package ladder.domain.dto;

import ladder.domain.ladder.Ladder;

import java.util.List;

public class LadderShapeResult {

    private final List<String> playerNames;
    private final List<String> prizeNames;
    private final List<StairDto> stairDtos;

    private LadderShapeResult(final List<String> playerNames, final List<String> prizeNames, final List<StairDto> stairDtos) {
        this.playerNames = playerNames;
        this.prizeNames = prizeNames;
        this.stairDtos = stairDtos;
    }

    public static LadderShapeResult of(final List<String> playerNames, final List<String> prizeNames, final Ladder ladder) {
        return new LadderShapeResult(playerNames, prizeNames, StairDto.from(ladder));
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public List<String> getPrizeNames() {
        return prizeNames;
    }

    public List<StairDto> getStairDtos() {
        return stairDtos;
    }
}
