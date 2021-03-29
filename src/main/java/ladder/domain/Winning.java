package ladder.domain;

import ladder.dto.Name;

import java.util.LinkedHashMap;
import java.util.Map;

public class Winning {

    private final Map<Name, Integer> winning = new LinkedHashMap<>();

    public Map<Name, Integer> getWinning() {
        return winning;
    }

    public void record(Name name, int resultIndex) {
        winning.put(name, resultIndex);
    }
}
