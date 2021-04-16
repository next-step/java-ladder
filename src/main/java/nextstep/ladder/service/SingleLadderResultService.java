package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.User;
import nextstep.ladder.entity.user.Users;

import java.util.ArrayList;
import java.util.List;

public class SingleLadderResultService implements LadderResultService {
    private final String name;

    public SingleLadderResultService(String name) {
        this.name = name;
    }

    @Override
    public List<String> result(Users users, LadderResults ladderResults, Ladder ladder) {
        List<String> gameResults = new ArrayList<>();
        int position = users.startPosition(name);
        gameResults.add(ladderResults.positionResult(ladder.gameEndPosition(position)));
        return gameResults;
    }
}
