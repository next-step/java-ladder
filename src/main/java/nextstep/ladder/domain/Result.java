package nextstep.ladder.domain;

import java.util.Map;

public class Result {

    private final PlayerReward result;

    private Result(PlayerReward result) {
        this.result = result;
    }

    public static Result newInstance(PlayerReward result) {
        validate(result);
        return new Result(result);
    }

    private static void validate(PlayerReward result) {
        if (result == null || result.count() == 0) {
            throw new IllegalArgumentException("결과가 존재하지 않습니다.");
        }
    }

    public Reward get(Player player) {
        return this.result.get(player);
    }

    public Map<Player, Reward> toMap() {
        return this.result.toMap();
    }
}
