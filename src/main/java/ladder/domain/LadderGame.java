package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

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
        ladder.drawLine(drawRule);
        return ladder;
    }

    public LadderResult run() {
        return LadderResult.of(ladder.searchLine());
    }
}
