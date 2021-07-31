package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.PlayersAndGifts;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderPosition;
import nextstep.ladder.domain.ladder.LadderRideResult;
import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.dto.MatchResult;
import nextstep.ladder.exception.NullArgumentException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class LadderGame {
    private final PlayersAndGifts playersAndGifts;
    private final Ladder ladder;

    private LadderGame(LadderGameInitInfo ladderGameInitInfo) {
        validate(ladderGameInitInfo);

        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
        this.playersAndGifts = ladderGameInitInfo.getPlayersAndGifts();
    }

    private void validate(LadderGameInitInfo ladderGameInitInfo) {
        if (Objects.isNull(ladderGameInitInfo)) {
            throw new NullArgumentException(LadderGameInitInfo.class);
        }
    }

    public static LadderGame init(LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public MatchResult match() {
        Map<String, String> matchResult = new LinkedHashMap<>();
        LadderRideResult ladderRideResult = ladder.ride();

        IntStream.range(0, playersAndGifts.numberOfPlayers())
                .forEach(matchPlayerAndGift(matchResult, ladderRideResult));

        return MatchResult.from(matchResult);
    }

    private IntConsumer matchPlayerAndGift(Map<String, String> matchResult, LadderRideResult ladderRideResult) {
        return position -> {
            LadderPosition startPosition = LadderPosition.from(position);
            matchResult.put(
                    playersAndGifts.getPlayerNameAt(startPosition),
                    playersAndGifts.getGiftAt(ladderRideResult.endPositionOf(startPosition))
            );
        };
    }

    public LadderResult result() {
        return LadderResult.of(playersAndGifts, ladder);
    }
}
