package ladder.domain.ladder;

import ladder.domain.line.Height;
import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.player.Players;
import ladder.domain.point.RandomPointGenerator;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Ladder {

    private final Players players;
    private final Lines lines;

    private Ladder(Players players, Height height) {
        this.players = Optional.ofNullable(players)
                .orElseThrow(IllegalArgumentException::new);

        this.lines = Optional.ofNullable(height)
                .map(this::generateLines)
                .orElseThrow(IllegalArgumentException::new);
    }

    private Lines generateLines(Height height) {
        return Stream.generate(() -> Line.create(players.getCount(), new RandomPointGenerator()))
                .limit(height.getValue())
                .collect(collectingAndThen(toList(), Lines::create));
    }

    public static Ladder create(Players players, Height height) {
        return new Ladder(players, height);
    }

    public Lines getLines() {
        return lines;
    }
}
