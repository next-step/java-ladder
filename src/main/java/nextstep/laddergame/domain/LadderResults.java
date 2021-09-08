package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;

public class LadderResults {

    private final Map<PlayerName, String> results;

    public LadderResults(Map<PlayerName, String> results) {
        this.results = Collections.unmodifiableMap(results);
    }

    public String getResult(String name) {
        if (!results.containsKey(PlayerName.of(name))) {
            throw new NoSuchElementException(String.format("존재하지 않는 참여자입니다. name: %s", name));
        }
        return results.get(PlayerName.of(name));
    }
}
