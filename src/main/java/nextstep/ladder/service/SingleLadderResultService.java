package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;

import java.util.Collections;
import java.util.List;

public class SingleLadderResultService implements LadderResultService {
    private final int position;

    public SingleLadderResultService(int position) {
        this.position = position;
    }

    @Override
    public List<String> result(LadderResults ladderResults, Ladder ladder) {
        return Collections.singletonList(ladderResults.positionResult(ladder.gameEndPosition(position)));
    }
}
