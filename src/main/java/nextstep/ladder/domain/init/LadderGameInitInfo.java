package nextstep.ladder.domain.init;

import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayersAndResults playersAndResults;

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, PlayersAndResults playersAndResults) {
        validate(ladderInitInfo, playersAndResults);

        this.ladderInitInfo = ladderInitInfo;
        this.playersAndResults = playersAndResults;
    }
    private void validate(LadderInitInfo ladderInitInfo, PlayersAndResults playersAndResults) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new NullArgumentException(LadderInitInfo.class);
        }

        if (Objects.isNull(playersAndResults)) {
            throw new NullArgumentException(PlayersAndResults.class);
        }
    }

    public static LadderGameInitInfo of(PlayersAndResults playersAndResults, LadderInitInfo ladderInitInfo) {
        return new LadderGameInitInfo(ladderInitInfo, playersAndResults);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayersAndResults getPlayersAndResults() {
        return playersAndResults;
    }
}
