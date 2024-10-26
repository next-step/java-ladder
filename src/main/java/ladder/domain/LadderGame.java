package ladder.domain;

import java.util.List;
import ladder.strategy.RandomGenerateStrategy;

public class LadderGame {
    private static final String INCORRECT_RESULT_SIZE = "사다리 결과와 사용자의 수가 다릅니다.";
    private static final String END_CONDITION = "all";

    private final Users users;
    private final Ladder ladder;
    private final LadderPrizes ladderPrizes;
    private final LadderResult ladderResult;

    public LadderGame(List<UserName> userNames, List<LadderPrize> prizes, int maxLength) {
        validateResultsCount(userNames, prizes);
        this.users = new Users(userNames);
        this.ladder = new Ladder(maxLength, users, new RandomGenerateStrategy());
        this.ladderPrizes = new LadderPrizes(prizes);
        this.ladderResult = decideResult();
    }

    private void validateResultsCount(List<UserName> userNames, List<LadderPrize> prizes) {
        if (userNames.size() != prizes.size()) {
            throw new IllegalArgumentException(INCORRECT_RESULT_SIZE);
        }
    }

    private LadderResult decideResult() {
        return LadderResult.of(users, ladderPrizes, ladder.rideLadder(users.size()));
    }

    public LadderPrize findUserToPrize(String name) {
        UserName userName = users.findByName(name);
        return ladderResult.findByUser(userName);
    }

    public boolean isEnd(String inputValue) {
        return inputValue.equals(END_CONDITION);
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderPrizes getLadderPrizes() {
        return ladderPrizes;
    }

    public LadderResult getLadderResult() {
        return ladderResult;
    }
}
