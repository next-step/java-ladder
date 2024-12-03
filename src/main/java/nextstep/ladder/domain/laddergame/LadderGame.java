package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.position.Positions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public LadderGameResult play() {
        List<Positions> positionsList = IntStream.range(0, ladder.getPlayers().size())
                                                 .mapToObj(i -> new Positions().add(ladder.getLines(), i))
                                                 .collect(Collectors.toList());

        return new LadderGameResult(ladder.getPlayers(), positionsList, ladderResult);
    }

}
