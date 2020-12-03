package ladder.domain.model;

import ladder.domain.ladder.LadderHeight;
import ladder.domain.result.ResultPrize;
import ladder.domain.user.Users;

public class LadderGameInfo {

    private final Users users;
    private final ResultPrize resultPrize;
    private final LadderHeight ladderHeight;

    public LadderGameInfo(Users users, ResultPrize resultPrize, LadderHeight ladderHeight) {
        this.users = users;
        this.resultPrize = resultPrize;
        this.ladderHeight = ladderHeight;
    }

    public Users getUsers() {
        return users;
    }

    public ResultPrize getResultPrize() {
        return resultPrize;
    }

    public LadderHeight getLadderHeight() {
        return ladderHeight;
    }
}
