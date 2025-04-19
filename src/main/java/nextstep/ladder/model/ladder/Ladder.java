package nextstep.ladder.model.ladder;

import nextstep.ladder.model.player.Players;
import nextstep.ladder.strategy.DefaultRandomPointGenerator;
import nextstep.ladder.strategy.RandomPointGenerator;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final Players players, final Height height) {
        this(players, height, new DefaultRandomPointGenerator());
    }
    
    public Ladder(final Players players, final Height height, final RandomPointGenerator pointGenerator) {
        this.lines = createLadder(players, height, pointGenerator);
    }
    
    private List<Line> createLadder(final Players players, final Height height, final RandomPointGenerator pointGenerator) {
        return IntStream.range(0, height.getValue())
                .mapToObj(i -> new Line(players, pointGenerator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public Position run(final Position startPosition) {
        return lines.stream()
                .reduce(startPosition, this::applyLineToPosition, (p1, p2) -> p2);
    }
    
    private Position applyLineToPosition(final Position position, final Line line) {
        return line.movePosition(position);
    }
} 
