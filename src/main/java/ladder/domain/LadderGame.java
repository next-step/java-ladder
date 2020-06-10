package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.dto.LadderShapeResult;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.exception.ErrorMessage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LadderGame {

    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    private LadderGame(final LadderShapeInfo ladderShapeInfo) {
        validateLadderShapeInfo(ladderShapeInfo);
        this.players = ladderShapeInfo.getPlayers();
        this.prizes = ladderShapeInfo.getPrizes();
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
        return LadderShapeResult.of(players.getNames(), prizes.getNames(), ladder);
    }

    public LadderMatchResult play() {
        List<Integer> prizePositions = ladder.ride();

        Map<Player, Prize> matchResult = new LinkedHashMap<>();
        IntStream.range(0, players.count())
                .forEach(index -> {
                    Player player = players.indexOf(index);
                    Prize prize = prizes.indexOf(prizePositions.get(index));

                    matchResult.put(player, prize);
                });

        return LadderMatchResult.of(matchResult);
    }
}
