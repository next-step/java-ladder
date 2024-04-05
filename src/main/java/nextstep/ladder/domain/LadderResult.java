package nextstep.ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LadderResult {
    private final List<String> results;

    private final LineLength length;

    public LadderResult(List<String> results, int length) {
        assertNotEmpty(results);
        this.length = new LineLength(length);

        assertEqualLength(results, this.length);
        this.results = results;
    }

    private void assertNotEmpty(List<String> results) {
        String emptyMessage = "[사다리] 빈 결과 값이 있습니다.";
        Optional.ofNullable(results)
                .orElseThrow(() -> new IllegalArgumentException(emptyMessage))
                .stream().filter(result -> result.isEmpty() || result.isBlank())
                .findAny()
                .ifPresent(emptyData -> {
                    throw new IllegalArgumentException(emptyMessage);
                });

    }

    private void assertEqualLength(List<String> results, LineLength length) {
        String notEqualMessage = "[사다리] 사라디 결과 개수랑 사다리 길이랑 다릅니다.";
        if (results.size() != length.getLength()) {
            throw new IllegalArgumentException(notEqualMessage);
        }
    }

    public List<String> getResults() {
        return results.stream().collect(Collectors.toUnmodifiableList());
    }

}
