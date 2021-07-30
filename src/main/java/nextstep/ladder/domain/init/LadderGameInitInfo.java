package nextstep.ladder.domain.init;

import nextstep.ladder.exception.NullArgumentException;

import java.util.Objects;

public class LadderGameInitInfo {
    private final LadderInitInfo ladderInitInfo;
    private final PlayersAndGifts playersAndGifts;

    private LadderGameInitInfo(LadderInitInfo ladderInitInfo, PlayersAndGifts playersAndGifts) {
        validate(ladderInitInfo, playersAndGifts);

        this.ladderInitInfo = ladderInitInfo;
        this.playersAndGifts = playersAndGifts;
    }
    private void validate(LadderInitInfo ladderInitInfo, PlayersAndGifts playersAndGifts) {
        if (Objects.isNull(ladderInitInfo)) {
            throw new NullArgumentException(LadderInitInfo.class);
        }

        if (Objects.isNull(playersAndGifts)) {
            throw new NullArgumentException(PlayersAndGifts.class);
        }
    }

    public static LadderGameInitInfo of(PlayersAndGifts playersAndGifts, LadderInitInfo ladderInitInfo) {
        return new LadderGameInitInfo(ladderInitInfo, playersAndGifts);
    }

    public LadderInitInfo getLadderInitInfo() {
        return ladderInitInfo;
    }

    public PlayersAndGifts getPlayersAndGifts() {
        return playersAndGifts;
    }
}
