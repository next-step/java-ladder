package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserCollection;

public class LadderInput {
    private final UserCollection userCollection;
    private final ResultCollection resultCollection;

    public LadderInput(UserCollection userCollection, ResultCollection resultCollection) {
        validate(userCollection, resultCollection);
        this.userCollection = userCollection;
        this.resultCollection = resultCollection;
    }

    public void validate(UserCollection userCollection, ResultCollection resultCollection) {
        if (userCollection.size() != resultCollection.size()) {
            throw new IllegalArgumentException("유저와 결과 수가 동일하지 않습니다.");
        }
        if (userCollection.size() < 2) {
            throw new IllegalArgumentException("사다리는 2명 이상의 유저가 필요합니다.");
        }
    }

    public int size() {
        return userCollection.size();
    }


    public int getUserIndex(String userName) {
        return userCollection.getIndex(userName);
    }


    public User getUserFromIndex(int userIndex) {
        return userCollection.getUserFromIndex(userIndex);
    }

    public Result getResultFromIndex(int resultIndex) {
        return resultCollection.getResultFromIndex(resultIndex);
    }
}
