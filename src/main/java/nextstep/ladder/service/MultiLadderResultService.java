package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.GameResult;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.User;
import nextstep.ladder.entity.user.Users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MultiLadderResultService implements LadderResultService {

    private final Users users;

    public MultiLadderResultService(Users users) {
        this.users = users;
    }

    @Override
    public List<GameResult> result(LadderResults ladderResults, Ladder ladder) {
        return Collections.unmodifiableList(users.users().stream()
                .map(user -> ladderResults.positionResult(user.name(), ladder.gameEndPosition(user.startPosition())))
                .collect(Collectors.toList()));
    }
}
