package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult2;
import ladder.domain.ladder.Ladder2;
import ladder.domain.ladder.shape.LadderShapeInfo2;
import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import ladder.exception.ErrorMessage;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame2 {

    private final PlayersAndPrizes playersAndPrizes;
    private final Ladder2 ladder;

    private LadderGame2(final LadderShapeInfo2 ladderShapeInfo) {
        validateLadderShapeInfo(ladderShapeInfo);
        this.playersAndPrizes = ladderShapeInfo.getPlayersAndPrizes();
        this.ladder = Ladder2.of(ladderShapeInfo);
    }

    public static LadderGame2 of(final LadderShapeInfo2 ladderShapeInfo) {
        return new LadderGame2(ladderShapeInfo);
    }

    private static void validateLadderShapeInfo(final LadderShapeInfo2 ladderShapeInfo) {
        if (Objects.isNull(ladderShapeInfo)) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public LadderShapeResult2 ready() {
        return LadderShapeResult2.of(playersAndPrizes, ladder);
    }

    public LadderMatchResult play() {
        List<Integer> prizePositions = ladder.ride();
        Map<Player, Prize> matchResult = playersAndPrizes.matchPlayerAndPrize(prizePositions);

        return LadderMatchResult.of(matchResult);
    }
}
