package nextstep.ladder.domain;

import java.util.List;

public class LadderResult {
    private final List<String> ladderResult;

    public LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public String getValueOfIndex(int userDepartPosition) {
        return ladderResult.get(userDepartPosition);
    }
}
