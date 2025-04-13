package nextstep.ladder.domain.edge;

public class LadderConfig {

    private final LadderUsers ladderUsers;
    private final LadderPrizes ladderPrizes;

    public LadderConfig(LadderUsers ladderUsers, LadderPrizes ladderPrizes) {
        if (ladderUsers.size() != ladderPrizes.size()) {
            throw new IllegalArgumentException("유저와 결과 수가 맞지 않습니다.");
        }
        this.ladderUsers = ladderUsers;
        this.ladderPrizes = ladderPrizes;
    }
}
