package nextstep.domain.ladder;

import nextstep.domain.line.Line;
import nextstep.domain.player.Players;
import nextstep.generator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;
    private Height height;

    public Ladder(Players players, Height height) {
        this.lines = makeLadder(players, height);
        this.height = height;
    }

    private List<Line> makeLadder(Players players, Height height) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        return IntStream.range(0, height.getHeight())
                .mapToObj(line -> new Line(players.getPlayersCount(), randomNumberGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getAllLines(){
        return lines;
    }

    public int getLadderHeight(){
        return height.getHeight();
    }
}
