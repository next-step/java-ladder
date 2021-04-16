package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;

import java.util.List;

public interface LadderResultService {
    List<String> result( LadderResults ladderResults, Ladder ladder);
}
