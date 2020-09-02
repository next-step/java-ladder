package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.stream.IntStream;

public class LadderGame2 {

    private final int rows;
    private final Players players;
    private final Ladder2 ladder2;

    @Builder
    public LadderGame2(Players players, int rows) {
        this.players = players;
        this.rows = rows;
        this.ladder2 = Ladder2.builder()
                .rowNumber(rows)
                .columnNumber(players.getCountOfPlayers())
                .build();
    }

    public Ladder2 makeLadder(DrawRule drawRule) {
        IntStream
                .range(0, rows)
                .forEach(line -> draw(line, drawRule));
        return ladder2;
    }

    private void draw(int rowPosition, DrawRule drawRule) {
        IntStream
                .range(0, players.getCountOfPlayers() - 1)
                .forEach(columnPosition -> {
                    if (drawRule.isDrawable()) {
                        ladder2.drawLine(rowPosition, columnPosition);
                    }
                });
    }
}
