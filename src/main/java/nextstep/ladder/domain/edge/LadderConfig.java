package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.Lines;

import java.util.List;
import java.util.Map;

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

    public int size() {
        return ladderUsers.size();
    }

    public List<String> getUsersName() {
        return ladderUsers.getLadderUserNames();
    }

    public List<String> getPrizesValue() {
        return ladderPrizes.getLadderPrizes();
    }

    public Map<String, String> getResultString(Lines lines) {
        return toResult(lines).getStringValues();
    }

    private LadderResult toResult(Lines lines) {
        LadderUsers moved = lines.moveUsers(ladderUsers);
        return new LadderResult(moved, moved.selectAll(ladderPrizes));
    }
}
