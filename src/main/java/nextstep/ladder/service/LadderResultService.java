package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.GameResult;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;

import java.util.List;

public interface LadderResultService {
    List<GameResult> result(LadderResults ladderResults, Ladder ladder);
}
