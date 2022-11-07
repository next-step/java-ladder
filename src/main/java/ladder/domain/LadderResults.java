package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderResults {
    private static final String INPUT_RESULT_EXCEPTION_MESSAGE = "사다리 실행결과는 멤버의 인원수 만큼 입력해줘야 합니다.";

    private final List<LadderResult> results;

    public LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public static List<LadderResult> addResult(List<String> results, int memberCount) {
        validateCountSize(results, memberCount);
        return results.stream()
                .map(LadderResult::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateCountSize(List<String> results, int memberCount) {
        if (results.size() != memberCount) {
            throw new IllegalArgumentException(INPUT_RESULT_EXCEPTION_MESSAGE);
        }
    }

    public List<LadderResult> getResults() {
        return Collections.unmodifiableList(results);
    }
}
