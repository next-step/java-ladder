package ladder.domain.ladder;

import ladder.domain.user.Name;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<Name, String> results = new LinkedHashMap<>();

    void put(Name participant, String ladderResult) {
        results.put(participant, ladderResult);
    }

    public Map<Name, String> getResults(String name) {
        if (new Name("all").equals(new Name(name))) {
            return Collections.unmodifiableMap(results);
        }
        String findName = results.get(new Name(name));
        if (findName == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자 입니다.");
        }

        Map<Name, String> result = new LinkedHashMap<>();
        result.put(new Name(name), findName);
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
