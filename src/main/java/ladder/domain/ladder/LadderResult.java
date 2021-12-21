package ladder.domain.ladder;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<String, String> results = new LinkedHashMap<>();

    void put(String participant, String ladderResult) {
        results.put(participant, ladderResult);
    }

    public Map<String, String> getResults(String name) {
        if ("all".equals(name)) {
            return Collections.unmodifiableMap(results);
        }
        String findName = results.get(name);
        if (findName == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자 입니다.");
        }

        Map<String, String> result = new LinkedHashMap<>();
        result.put(name, findName);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
