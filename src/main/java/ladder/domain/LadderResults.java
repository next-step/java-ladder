package ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderResults {

    private final List<LadderResult> ladderResults;

    public LadderResults(final List<LadderResult> ladderResults) {
        validateOrThrow(ladderResults);

        this.ladderResults = ladderResults;
    }

    private void validateOrThrow(final List<LadderResult> ladderResults) {
        if (Objects.isNull(ladderResults) || ladderResults.isEmpty()) {
            throw new IllegalArgumentException("빈 사다리 결과는 생성될 수 없습니다.");
        }
    }

    public List<LadderResult> getLadderResults() {
        return this.ladderResults;
    }

    public LadderResult get(final int index) {
        return this.ladderResults.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResults that = (LadderResults) o;
        return Objects.equals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderResults);
    }
}
