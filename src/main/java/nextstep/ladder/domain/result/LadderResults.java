package nextstep.ladder.domain.result;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(int playerCount, String[] resultArray) {
        validateResults(playerCount, resultArray);

        ladderResults = Arrays.stream(resultArray)
                .map(LadderResult::new)
                .collect(Collectors.toList());
    }

    private void validateResults(int playerCount, String[] results) {
        if (playerCount != results.length) {
            throw new IllegalArgumentException("실행결과 수는 플레이어 수와 같아야 합니다.");
        }
    }

    public LadderResult find(int index) {
        return ladderResults.get(index);
    }

    public List<LadderResult> getLadderResults() {
        return Collections.unmodifiableList(ladderResults);
    }
}
