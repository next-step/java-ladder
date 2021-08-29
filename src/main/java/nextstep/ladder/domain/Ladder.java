package nextstep.ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final Players players, final Height height) {
        this.lines = height.intStream()
                .mapToObj(i -> new Line(players.count()))
                .collect(Collectors.toList());
    }

    public Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public List<List<Boolean>> getLadderBarStatus() {
        return lines.stream()
                .map(Line::getLineBarStatus)
                .collect(Collectors.toList());
    }

    public int startMoving(int startPosition) {
        AtomicInteger position = new AtomicInteger(startPosition);
        lines.forEach(line -> {
            int nextPosition = line.moveFrom(position.get());
            position.set(nextPosition);
        });
        return position.get();
    }

}
