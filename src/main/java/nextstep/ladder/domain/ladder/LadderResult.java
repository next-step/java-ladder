package nextstep.ladder.domain.ladder;

import java.util.Collections;
import java.util.List;

public class LadderResult {
    private final List<String> ladderResult;

    public LadderResult(List<String> ladderResult) {
        this.ladderResult = ladderResult;
    }

    public LadderResult(List<String> ladderResult, int playerCount) {
        if (playerCount != ladderResult.size()) {
            throw new IllegalArgumentException("사다리 게임의 결과는 플레이어 수와 동일해야 합니다.");
        }

        this.ladderResult = ladderResult;
    }

    public List<String> getLadderResult() {
        return Collections.unmodifiableList(ladderResult);
    }

    public String getResultByIndex(int index) {
        return ladderResult.get(index);
    }
}
