package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResults {

    private final Map<String, String> results;

    public LadderResults(final List<LadderResult> results) {
        this.results = results.stream()
                .collect(Collectors.toMap(LadderResult::getName, LadderResult::getResult, (a, b) -> b));
    }

    public String getResult(final String name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException(String.format("name: %s 는 유효하지 않은 참가자입니다.", name));
        }
        return results.get(name);
    }

    public Map<String, String> getResults() {
        return Collections.unmodifiableMap(results);
    }
}
