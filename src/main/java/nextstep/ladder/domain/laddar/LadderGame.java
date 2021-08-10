package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.ResultDto;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.strategy.DirectionRandomStrategy;

import java.util.Objects;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    private LadderGame(final Ladder ladder, final Players players) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderGame of(final Players players, final int ladderHeight) {
        LadderSize ladderSize = LadderSize.of(Objects.requireNonNull(players).getNames().size(), ladderHeight);
        LadderGameContext ladderGameContext = LadderGameContext.of(ladderSize, DirectionRandomStrategy.getInstance());
        return new LadderGame(Ladder.from(ladderGameContext), players);
    }

    public ResultDto getGameResult() {
        return ResultDto.of(players.getNames(), ladder.convert());
    }
}
