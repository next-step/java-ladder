package nextstep.domain.ladder;

import nextstep.domain.line.Line;
import nextstep.domain.player.Players;
import nextstep.generator.PointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private final PointGenerator pointGenerator;

    public Ladder(Players players, Height height, PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
        this.lines = makeLadder(players, height);
    }

    private List<Line> makeLadder(Players players, Height height) {
        return IntStream.range(0, height.getHeight())
                .mapToObj(line -> new Line(players.getPlayersCount(), pointGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getAllLines() {
        return lines;
    }

}
