package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;

import java.util.ArrayList;
import java.util.List;

public class SingleLadderResultService implements LadderResultService {
    private final int position;

    public SingleLadderResultService(int position) {
        this.position = position;
    }

    @Override
    public List<String> result(LadderResults ladderResults, Ladder ladder) {
        List<String> gameResults = new ArrayList<>();
        gameResults.add(ladderResults.positionResult(ladder.gameEndPosition(position)));
        return gameResults;
    }
}
