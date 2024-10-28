package ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderPlayResult {
    private final Map<Person, String> playResult;

    public LadderPlayResult(Map<Person, String> playResult) {
        this.playResult = playResult;
    }

    public String get(Person person) {
        return playResult.get(person);
    }

    public Map<Person, String> getLadderPlayResult() {
        return new LinkedHashMap<>(playResult);
    }

}
