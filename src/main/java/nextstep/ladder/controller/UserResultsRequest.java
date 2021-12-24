package nextstep.ladder.controller;

import nextstep.ladder.model.LadderResult;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.User;
import nextstep.ladder.model.Users;

public final class UserResultsRequest {

    private final Users users;
    private final LadderResults ladderResults;

    private UserResultsRequest(Users users, LadderResults ladderResults) {
        this.users = users;
        this.ladderResults = ladderResults;
    }

    public static UserResultsRequest of(Users users, LadderResults ladderResults) {
        validate(users, ladderResults);
        return new UserResultsRequest(users, ladderResults);
    }

    private static void validate(Users users, LadderResults ladderResults) {
        if (users.size() != ladderResults.size()) {
            throw new IllegalArgumentException("유저와 결과 수가 동일하지 않습니다.");
        }
    }

    public int size() {
        return users.size();
    }
}
