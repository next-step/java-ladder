package nextstep.ladder.module;

import java.util.Map;
import java.util.stream.Collectors;

public class BoardResult {

    private final Map<Name, Integer> resultMap;
    private final ResultList resultNames;

    public BoardResult(Map<Name, Integer> resultMap, ResultList resultNames) {
        this.resultMap = resultMap;
        this.resultNames = resultNames;
    }

    public Result of(Name name) {
        return resultNames.get(resultMap.get(name));
    }

    public Map<Name, Result> all() {
        return resultMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> resultNames.get(entry.getValue())));
    }
}
