package ladder.domain;

import ladder.dto.Name;
import ladder.dto.Result;

import java.util.LinkedHashMap;
import java.util.Map;

public class Winning {

    private final Map<Name, Result> winning = new LinkedHashMap<>();

    public Map<Name, Result> getWinning() {
        return winning;
    }

    public void record(Name name, Result result) {
        winning.put(name, result);
    }
}
