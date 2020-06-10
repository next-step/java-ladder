package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {

    private final PlayersAndPrizes playersAndPrizes;
    private final Ladder ladder;

    private LadderGame(final LadderShapeInfo ladderShapeInfo) {
        validateLadderShapeInfo(ladderShapeInfo);
        this.playersAndPrizes = ladderShapeInfo.getPlayersAndPrizes();
        this.ladder = Ladder.of(ladderShapeInfo);
    }

    public static LadderGame of(final LadderShapeInfo ladderShapeInfo) {
        return new LadderGame(ladderShapeInfo);
    }

    private static void validateLadderShapeInfo(final LadderShapeInfo ladderShapeInfo) {
        if (Objects.isNull(ladderShapeInfo)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public LadderShapeResult ready() {
        return LadderShapeResult.of(playersAndPrizes, ladder);
    }

    public LadderMatchResult play() {
        List<Integer> prizePositions = ladder.ride();
        Map<Player, Prize> matchResult = playersAndPrizes.matchPlayerAndPrize(prizePositions);

        return LadderMatchResult.of(matchResult);
    }
}
