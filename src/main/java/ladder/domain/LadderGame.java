package ladder.domain;

import ladder.domain.rule.DrawRule;
import lombok.Builder;

import java.util.stream.IntStream;

public class LadderGame {

    private final int lines;
    private final Players players;
    private final Ladder ladder;

    @Builder
    public LadderGame(Players players, int lines) {
        this.players = players;
        this.lines = lines;
        this.ladder = Ladder.builder()
                .countOfPoints(players.getCountOfPlayers())
                .countOfLines(lines).build();
    }

    public Ladder makeLadder(DrawRule ladderDrawRule) {
        IntStream
                .range(0, lines)
                .forEach(line -> draw(line, ladderDrawRule));
        return ladder;
    }

    private void draw(int positionOfLine, DrawRule ladderDrawRule) {
        IntStream
                .range(0, players.getCountOfPlayers() - 1)
                .forEach(positionOfColumn -> {
                    if (ladderDrawRule.canDraw()) {
                        ladder.drawLine(positionOfLine, positionOfColumn);
                    }
                });
    }

}
