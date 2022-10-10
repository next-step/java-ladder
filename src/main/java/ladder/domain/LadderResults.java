package ladder.domain;

import java.util.List;
import java.util.NoSuchElementException;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        this.ladderResults = ladderResults;
    }

    public List<LadderResult> ladderResults() {
        return ladderResults;
    }

    public int count() {
        return ladderResults.size();
    }

    public LadderResult findByPosition(int position) {
        return ladderResults.stream()
                .filter(ladderResult -> ladderResult.position() == position)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("position=%s에 해당하는 사다리 결과가 없습니다.", position)));
    }
}
