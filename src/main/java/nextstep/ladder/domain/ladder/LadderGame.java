package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.result.ResultCollection;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserCollection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final UserCollection userCollection;
    private final Ladder ladder;
    private final ResultCollection resultCollection;

    public LadderGame(UserCollection userCollection, Ladder ladder, ResultCollection resultCollection) {
        this.userCollection = userCollection;
        this.ladder = ladder;
        this.resultCollection = resultCollection;
    }

    public LadderResult getLadderResult(String userName) {
        int userIndex = userCollection.getUserIndex(userName);
        return ladderMove(userIndex);
    }

    public List<LadderResult> getAllLadderResult(){
        return IntStream.range(0, userCollection.size())
                .boxed()
                .map(this::ladderMove)
                .collect(Collectors.toList());
    }

    private LadderResult ladderMove(int userIndex){
        int resultIndex = ladder.move(userIndex);
        User user = userCollection.getUserFromIndex(userIndex);
        Result result = resultCollection.getResultFromIndex(resultIndex);
        return new LadderResult(user, result);
    }

}
