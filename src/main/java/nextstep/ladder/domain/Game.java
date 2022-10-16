package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.DefaultEnablePointStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static final String INVALID_COUNT_EXCEPTION_MESSAGE = "플레이어 수 만큼의 결과를 입력해주세요.";
    private static final DefaultEnablePointStrategy DEFAULT_STRATEGY = new DefaultEnablePointStrategy();

    private final Ladder ladder;
    private final Map<Player, String> matchTable = new LinkedHashMap<>();

    public Game(Players players, Ladder ladder, String[] results) {
        checkSize(players, results);

        this.ladder = ladder;
        start(players, results);
    }

    private void checkSize(Players players, String[] results) {
        if (players.count() != results.length) {
            throw new IllegalArgumentException(INVALID_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void start(Players players, String[] results) {
        int index = 0;
        for (Player player : players.values()) {
            matchTable.put(player, results[destinationIndex(index)]);
            index++;
        }
    }

    private int destinationIndex(int playerIndex) {
        List<Line> lines = ladder.lines();

        int linePosition = 0;
        int pointPosition = playerIndex;

        while (true) {
            Point point = lines.get(linePosition).points().get(pointPosition);

            if (linePosition == lines.size() - 1) {
                return point.nextPosition();
            }

            pointPosition = point.nextPosition();
            linePosition += 1;
        }
    }

    public static Game of(Players players, int ladderHeight, String[] results) {
        Ladder ladder = Ladder.create(ladderHeight, players, DEFAULT_STRATEGY);

        return new Game(players, ladder, results);
    }

    public Ladder ladder() {
        return ladder;
    }

    public Map<Player, String> resultTable() {
        return Collections.unmodifiableMap(matchTable);
    }
}
