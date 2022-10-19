package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.DefaultEnablePointStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Result;
import nextstep.ladder.domain.ladder.Results;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Game {
    private static final String INVALID_COUNT_EXCEPTION_MESSAGE = "플레이어 수 만큼의 결과를 입력해주세요.";
    private static final DefaultEnablePointStrategy DEFAULT_STRATEGY = new DefaultEnablePointStrategy();

    private final Ladder ladder;
    private final Map<Player, Result> matchTable = new LinkedHashMap<>();

    public Game(Players players, Ladder ladder, Results results) {
        checkSize(players, results);

        this.ladder = ladder;
        start(players, results);
    }

    private void checkSize(Players players, Results results) {
        if (players.count() != results.size()) {
            throw new IllegalArgumentException(INVALID_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void start(Players players, Results results) {
        int index = 0;
        for (Player player : players.values()) {
            int destinationPosition = ladder.destinationPosition(index);
            matchTable.put(player, results.find(destinationPosition));
            index++;
        }
    }

    public static Game of(Players players, int ladderHeight, Results results) {
        Ladder ladder = Ladder.create(ladderHeight, players, DEFAULT_STRATEGY);

        return new Game(players, ladder, results);
    }

    public Ladder ladder() {
        return ladder;
    }

    public Map<Player, Result> resultTable() {
        return Collections.unmodifiableMap(matchTable);
    }
}
