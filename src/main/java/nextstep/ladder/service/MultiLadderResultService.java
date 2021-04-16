package nextstep.ladder.service;

import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.LadderResults;
import nextstep.ladder.entity.user.User;
import nextstep.ladder.entity.user.Users;

import java.util.ArrayList;
import java.util.List;

public class MultiLadderResultService implements LadderResultService {

    private final Users users;

    public MultiLadderResultService(Users users) {
        this.users = users;
    }

    @Override
    public List<String> result(LadderResults ladderResults, Ladder ladder) {
        List<Integer> startPositions = users.startPositions();
        List<String> gameResults = new ArrayList<>();

        for (Integer startPosition : startPositions) {
            User user = users.startPositionUser(startPosition);

            String gameResult = ladderResults.positionResult(user.name(), ladder.gameEndPosition(startPosition));

            gameResults.add(gameResult);
        }

        return gameResults;
    }
}
