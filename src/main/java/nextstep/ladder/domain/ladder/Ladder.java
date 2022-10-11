package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Players;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final Players players;

    public static Ladder create(int height, Players players, PointEnableStrategy pointEnableStrategy) {
        int countOfPlayer = players.count();

        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.create(countOfPlayer, pointEnableStrategy))
                .collect(Collectors.toList());

        return new Ladder(lines, players);
    }

    public Ladder(List<Line> lines, Players players) {
        this.lines = lines;
        this.players = players;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public Players players() {
        return players;
    }
}
