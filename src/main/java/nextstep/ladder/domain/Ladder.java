package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder implements Moveable {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return new Ladder(spokes.map(Line::new)
                                 .collect(toList()));
    }

    @Override
    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), nope());
    }

    public void forEach(Consumer<Line> singleLineConsumer) {
        lines.forEach(singleLineConsumer);
    }
}
