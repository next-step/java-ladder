package nextstep.ladder2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder2.domain.result.NxResult;
import nextstep.ladder2.domain.result.NxResultBoard;

public class NxLadderGame {
    private final NxLadder ladder;
    private final NxPrizeMapper prizeMapper;

    public NxLadderGame(NxLadder ladder, NxPrizeMapper prizeMapper) {
        this.ladder = ladder;
        this.prizeMapper = prizeMapper;
    }

    public NxResultBoard start() {
        List<NxResult> results = new ArrayList<>();
        IntStream.range(0, prizeMapper.getPlayerCount())
                .forEach(i -> results.add(prizeMapper.createResult(i, ladder.ride(i))));
        return new NxResultBoard(results);
    }
}
