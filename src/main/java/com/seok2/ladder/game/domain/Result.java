package com.seok2.ladder.game.domain;

import com.seok2.ladder.product.domain.Reward;
import com.seok2.ladder.user.domain.Player;

import java.util.Map;

public class Result {

    private final Map<Player, Reward> result;

    private Result(Map<Player, Reward> result) {
        this.result = result;
    }

    public static Result of(Map<Player, Reward> result) {
        return new Result(result);
    }

    public Map<Player, Reward> getResult() {
        return result;
    }
}
