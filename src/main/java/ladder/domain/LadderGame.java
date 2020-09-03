package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.stream.IntStream;

public class LadderGame {

    private final int rows;
    private final Players players;
    private final Ladder ladder;

    @Builder
    public LadderGame(Players players, int rows) {
        this.players = players;
        this.rows = rows;
        this.ladder = Ladder.builder()
                .rowCount(rows)
                .columnCount(players.getCountOfPlayers())
                .build();
    }

    public Ladder makeLadder(DrawRule drawRule) {
        IntStream
                .range(0, rows)
                .forEach(line -> draw(line, drawRule));
        return ladder;
    }

    private void draw(int rowPosition, DrawRule drawRule) {
        IntStream
                .range(0, players.getCountOfPlayers() - 1)
                .forEach(columnPosition -> {
                    if (drawRule.isDrawable()) {
                        ladder.drawLine(rowPosition, columnPosition);
                    }
                });
    }
}
