package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;

public class Result {

    private Map<Player, Reword> result;

    private Result(Map<Player, Reword> result) {
        this.result = result;
    }

    public static Result newInstance(Map<Player, Reword> result) {
        validate(result);
        return new Result(result);
    }

    private static void validate(Map<Player, Reword> result) {
        if (result == null || result.size() == 0) {
            throw new IllegalArgumentException("결과가 존재하지 않습니다.");
        }
    }

    public Reword get(Player player) {
        return this.result.get(player);
    }

    public Map<Player, Reword> toMap() {
        return Collections.unmodifiableMap(this.result);
    }
}
