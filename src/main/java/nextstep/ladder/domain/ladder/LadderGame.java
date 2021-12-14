package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.result.Result;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final LadderInput ladderInput;

    public LadderGame(Ladder ladder, LadderInput ladderInput) {
        this.ladder = ladder;
        this.ladderInput = ladderInput;
    }

    public LadderResult getLadderResult(String userName) {
        int userIndex = ladderInput.getUserIndex(userName);
        return ladderMove(userIndex);
    }

    public List<LadderResult> getAllLadderResult(){
        return IntStream.range(0, ladderInput.size())
                .boxed()
                .map(this::ladderMove)
                .collect(Collectors.toList());
    }

    private LadderResult ladderMove(int userIndex){
        int resultIndex = ladder.move(userIndex);
        User user = ladderInput.getUserFromIndex(userIndex);
        Result result = ladderInput.getResultFromIndex(resultIndex);
        return new LadderResult(user, result);
    }

}
