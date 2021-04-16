package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.Users;

import java.util.List;

public interface LadderResultService {
    List<String> result(Users users, LadderResults ladderResults, Ladder ladder);
}
