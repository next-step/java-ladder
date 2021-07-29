package nextstep.ladder;

import nextstep.ladder.domain.init.LadderGameInitInfo;
import nextstep.ladder.domain.init.PlayersAndResults;
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
    private final PlayersAndResults playersAndResults;
    private final Ladder ladder;

    private LadderGame(LadderGameInitInfo ladderGameInitInfo) {
        validate(ladderGameInitInfo);

        this.ladder = Ladder.init(ladderGameInitInfo.getLadderInitInfo());
        this.playersAndResults = ladderGameInitInfo.getPlayersAndResults();
    }

    private void validate(LadderGameInitInfo ladderGameInitInfo) {
        if (Objects.isNull(ladderGameInitInfo)) {
            throw new NullArgumentException(LadderGameInitInfo.class);
        }
    }

    public static LadderGame init(LadderGameInitInfo ladderGameInitInfo) {
        return new LadderGame(ladderGameInitInfo);
    }

    public MatchResult matchResult() {
        Map<String, String> matchResult = new LinkedHashMap<>();
        LadderRideResult ladderRideResult = ladder.ride();

        IntStream.range(0, playersAndResults.numberOfPlayers())
                .forEach(matchPlayerAndResult(matchResult, ladderRideResult));

        return MatchResult.from(matchResult);
    }

    private IntConsumer matchPlayerAndResult(Map<String, String> matchResult, LadderRideResult ladderRideResult) {
        return position -> {
            LadderPosition startPosition = LadderPosition.from(position);
            matchResult.put(
                    playersAndResults.getPlayerName(startPosition),
                    playersAndResults.getResult(ladderRideResult.endPositionOf(startPosition))
            );
        };
    }

    public LadderResult result() {
        return LadderResult.of(playersAndResults, ladder);
    }
}
