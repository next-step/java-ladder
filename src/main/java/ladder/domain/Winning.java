package ladder.domain;

import ladder.dto.Name;

import java.util.LinkedHashMap;
import java.util.Map;

public class Winning {

    private final Map<Name, String> winning = new LinkedHashMap<>();

    public Map<Name, String> getWinning() {
        return winning;
    }

    public void record(Name name, String result) {
        winning.put(name, result);
    }
}
