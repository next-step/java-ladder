package nextstep.ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderResultMap {
    private final Map<Name, Result> resultMap;

    private LadderResultMap(Map<Name, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public static LadderResultMap execute(Ladder ladder, Results results) {
        Map<Name, Result> resultMap = ladder.getIndexAfterMove().entrySet()
                .stream()
                .map(entry -> {
                    Name name = entry.getKey();
                    int index = entry.getValue();
                    Result result = results.getResult(index);
                    return Map.entry(name, result);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new LadderResultMap(resultMap);
    }

    public Map<Name, Result> getResultMap() {
        return Map.copyOf(resultMap);
    }
}
