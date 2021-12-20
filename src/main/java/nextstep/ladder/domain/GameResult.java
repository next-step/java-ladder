package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class GameResult {
    private static final int ADD_INDEX = 1;

    private final Map<Name, Integer> result;

    public GameResult(Ladder ladder, Names names) {
        this.result =  new HashMap<>();
        IntStream.range(0, names.getNames().size())
                .forEach(index -> {
                    Name name = names.getNames().get(index);
                    int endPoint = ladder.discovery(index + ADD_INDEX);
                    result.put(name, endPoint);
                });
    }

    public Map<Name, Integer> getGameResult() {
        return Collections.unmodifiableMap(result);
    }

    public Integer getResultIndex(Name name) {
        return result.get(name);
    }
}
