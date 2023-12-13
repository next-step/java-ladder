package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<Name, Integer> value;

    public LadderResult(Map<Name, Integer> value) {
        this.value = value;
    }

    public Map<Name, Integer> value() {
        return new HashMap<>(value);
    }

    public String result(Name playerName, List<String> result) {
        if (!value.containsKey(playerName)) {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }
        int finalPosition = value.get(playerName);

        return result.get(finalPosition);
    }
}
