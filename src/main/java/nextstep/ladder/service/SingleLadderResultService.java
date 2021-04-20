package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.GameResult;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;

import java.util.Collections;
import java.util.List;

public class SingleLadderResultService implements LadderResultService {
    private final String name;
    private final int position;

    public SingleLadderResultService(String name, int position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public List<GameResult> result(LadderResults ladderResults, Ladder ladder) {
        return Collections.singletonList(ladderResults.positionResult(name, ladder.gameEndPosition(position)));
    }
}
