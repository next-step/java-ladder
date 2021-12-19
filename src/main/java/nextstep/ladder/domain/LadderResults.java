package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;

public class LadderResults {
    private static final String EXCEPTION_MESSAGE_MEMBERS = "참가자를 찾을 수 없습니다.";
    private final List<LadderResult> results;

    public LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public String getResult(String member) {
        return results.stream()
                            .filter(ladderResult -> ladderResult.isMember(member))
                            .map(ladderResult -> ladderResult.getReward())
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_MESSAGE_MEMBERS));
    }

    public List<LadderResult> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResults that = (LadderResults) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
