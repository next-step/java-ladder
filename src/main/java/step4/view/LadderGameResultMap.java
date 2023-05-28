package step4.view;

import step4.domain.Ladder;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResultMap {
    private final Map<Name, Result> resultMap;

    public LadderGameResultMap(Names names, Ladder ladder, Results results) {
        this.resultMap = names.getNames()
                .stream()
                .collect(
                        Collectors.toUnmodifiableMap(
                                name -> name,
                                name ->  results.get(ladder.findResultPositionByIndex(names.indexOf(name)))
                        )
                );
    }

    public Map<Name, Result> getResultMap() {
        return resultMap;
    }

    public Result getResultByName(String name) {
        return resultMap.get(new Name(name));
    }
}
