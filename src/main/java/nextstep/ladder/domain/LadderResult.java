package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<String, Integer> value;

    public LadderResult(Map<String, Integer> value) {
        this.value = value;
    }

    public Map<String, Integer> value() {
        return new HashMap<>(value);
    }

    public String result(String playerName, List<String> result) {
        if (!value.containsKey(playerName)) {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }
        int finalPosition = value.get(playerName);

        return result.get(finalPosition);
    }
}
