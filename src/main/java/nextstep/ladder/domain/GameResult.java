package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class GameResult {
    private static final int INIT_INDEX = 0;

    private final Map<Name, Integer> result;

    public GameResult(Ladder ladder, Names names) {
        this.result =  new HashMap<>();
        IntStream.range(INIT_INDEX, names.getNames().size())
                .forEach(index -> {
                    Name name = names.getNames().get(index);
                    result.put(name, this.findGameResult(ladder, index));
                });
    }

    public Map<Name, Integer> getGameResult() {
        return Collections.unmodifiableMap(result);
    }

    public Integer getResultIndex(Name name) {
        return result.get(name);
    }

    private int findGameResult(Ladder ladder, int location) {
        return  ladder.discovery(location);
    }
}
