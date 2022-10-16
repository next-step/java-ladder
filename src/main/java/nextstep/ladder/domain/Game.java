package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.DefaultEnablePointStrategy;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.ladder.Point;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private static final DefaultEnablePointStrategy DEFAULT_STRATEGY = new DefaultEnablePointStrategy();

    private final Ladder ladder;
    private final Map<String, String> matchTable = new LinkedHashMap<>();

    public Game(Players players, String[] results, int ladderHeight) {
        if (players.count() != results.length) {
            throw new IllegalArgumentException("플레이어 수 만큼의 결과를 입력해주세요.");
        }

        this.ladder = Ladder.create(ladderHeight, players, DEFAULT_STRATEGY);
        start(players, results);
    }

    private void start(Players players, String[] results) {
        List<Player> values = players.values();

        int index = 0;
        for (Player value : values) {
            matchTable.put(value.name(), results[destinationIndex(index)]);
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

    public String getResult(String playerName) {
        if (playerName.equals("all")) {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : matchTable.entrySet()) {
                result.append(String.format("%s : %s\n", entry.getKey(), entry.getValue()));
            }

            return result.toString();
        }

        return matchTable.get(playerName);
    }

    public Ladder getLadder() {
        return this.ladder;
    }
}
