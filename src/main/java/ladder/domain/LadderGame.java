package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.Map;

public class LadderGame {

    private final int rows;
    private final Players players;
    private final Rewards rewards;
    private final Ladder ladder;

    @Builder
    public LadderGame(Players players, int rows, Rewards rewards) {
        this.rows = rows;
        this.players = players;
        this.rewards = rewards;
        this.ladder = Ladder.builder()
                .rowCount(rows)
                .columnCount(players.getCountOfPlayers())
                .build();
    }

    public Ladder makeLadder(DrawRule drawRule) {
        ladder.drawLine(drawRule);
        return ladder;
    }

    public GameResult run() {
        Map<Integer, Integer> ladderResult = ladder.searchLine();
        return GameResult.builder().ladderResults(ladderResult)
                .players(players)
                .rewards(rewards)
                .build();
    }
}
