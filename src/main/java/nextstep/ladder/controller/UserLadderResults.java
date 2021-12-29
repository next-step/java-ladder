package nextstep.ladder.controller;

import nextstep.ladder.model.LadderResult;
import nextstep.ladder.model.LadderResults;
import nextstep.ladder.model.User;
import nextstep.ladder.model.Users;

public final class UserLadderResults {

    private final Users users;
    private final LadderResults ladderResults;

    private UserLadderResults(Users users, LadderResults ladderResults) {
        this.users = users;
        this.ladderResults = ladderResults;
    }

    public static UserLadderResults of(Users users, LadderResults ladderResults) {
        validate(users, ladderResults);
        return new UserLadderResults(users, ladderResults);
    }

    private static void validate(Users users, LadderResults ladderResults) {
        int userSize = users.size();
        int ladderResultSize = ladderResults.size();
        if (userSize != ladderResultSize) {
            throw new IllegalArgumentException(String.format("유저 수(%d)와 결과 수(%d)가 동일하지 않습니다.", userSize, ladderResultSize));
        }
    }

    public int size() {
        return users.size();
    }

    public User getUser(int userIndex) {
        return users.get(userIndex);
    }

    public LadderResult getLadderResult(int index) {
        return ladderResults.get(index);
    }
}
