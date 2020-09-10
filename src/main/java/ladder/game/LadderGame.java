package ladder.game;

import ladder.domain.player.Players;
import ladder.domain.position.MovedPosition;
import ladder.domain.position.MovedPositions;
import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.stream.Collectors;

public class LadderGame {

    public static final String TARGET_ALL = "all";
    private final int rows;
    private final Players players;
    private Ladder ladder;

    @Builder
    public LadderGame(Players players, int rows) {
        this.rows = rows;
        this.players = players;
    }

    public Ladder makeLadder(DrawRule drawRule) {
        this.ladder = Ladder.builder()
                .rowCount(rows)
                .columnCount(players.getCountOfPlayers())
                .drawRule(drawRule)
                .build();
        return ladder;
    }

    public MovedPositions run(String name) {
        return players.getPlayers()
                .stream()
                .filter(player -> TARGET_ALL.equals(name) || player.matchName(name))
                .map(player -> MovedPosition.builder()
                        .name(player.getName())
                        .finalPosition(ladder.searchFinalPosition(player.getPosition()))
                        .build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), MovedPositions::of));
    }
}
