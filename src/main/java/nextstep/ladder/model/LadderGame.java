package nextstep.ladder.model;

import nextstep.ladder.controller.UsersLadderResults;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LadderGame {

    private final Ladder ladder;
    private final UsersLadderResults usersLadderResults;

    public LadderGame(Ladder ladder, UsersLadderResults usersLadderResults) {
        this.ladder = ladder;
        this.usersLadderResults = usersLadderResults;
    }

    public UserResults userResults() {
        return UserResults.from(processedUserResults());
    }

    private List<UserResult> processedUserResults() {
        return IntStream.range(0, usersLadderResults.size())
                .boxed()
                .map(this::userResult)
                .collect(Collectors.toList());
    }

    private UserResult userResult(int userIndex) {
        return new UserResult(
                usersLadderResults.getUser(userIndex),
                usersLadderResults.getLadderResult(ladder.move(userIndex))
        );
    }
}
