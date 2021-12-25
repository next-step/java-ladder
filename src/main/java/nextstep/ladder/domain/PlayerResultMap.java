package nextstep.ladder.domain;

import nextstep.ladder.engine.Name;
import nextstep.ladder.engine.Players;
import nextstep.ladder.engine.Prize;
import nextstep.ladder.engine.Prizes;
import nextstep.ladder.engine.ResultMap;

public class PlayerResultMap implements ResultMap {
    private final Players players;
    private final Prizes results;

    private PlayerResultMap(Players players, Prizes results) {
        this.players = players;
        this.results = results;
    }

    public static PlayerResultMap of(Players players, Prizes results) {
        if (players == null || results == null) {
            throw new IllegalArgumentException("players or results cannot be null");
        }

        return new PlayerResultMap(players, results);
    }

    public Prize result(Name player) {
        return results.elementOf(players.indexOf(player));
    }
}
