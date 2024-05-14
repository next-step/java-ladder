package nextstep.version.refactor.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderResult {
    Map<String, String> matchMap;

    public LadderResult(Map<String, String> matchMap) {
        this.matchMap = matchMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderResult)) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(matchMap, that.matchMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matchMap);
    }

    public int size() {
        return this.matchMap.size();
    }

    public List<String> getNameAndPrize() {
        return this.matchMap.entrySet()
                .stream().map(item -> item.getKey() + ":" + item.getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public String get(String name) {
        return this.matchMap.get(name);
    }
}
