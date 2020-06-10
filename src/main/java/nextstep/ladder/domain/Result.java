package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;

public class Result {

    private Map<Player, Reward> result;

    private Result(Map<Player, Reward> result) {
        this.result = result;
    }

    public static Result newInstance(Map<Player, Reward> result) {
        validate(result);
        return new Result(result);
    }

    private static void validate(Map<Player, Reward> result) {
        if (result == null || result.size() == 0) {
            throw new IllegalArgumentException("결과가 존재하지 않습니다.");
        }
    }

    public Reward get(Player player) {
        return this.result.get(player);
    }

    public Map<Player, Reward> toMap() {
        return Collections.unmodifiableMap(this.result);
    }
}
