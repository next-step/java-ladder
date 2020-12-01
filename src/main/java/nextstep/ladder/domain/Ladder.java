package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class Ladder implements Line {
    private final List<SingleLine> lines;

    public Ladder(List<SingleLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(Stream<Spoke> spokes) {
        return new Ladder(spokes.map(Spoke::toSingleLine)
                                 .collect(toList()));
    }

    @Override
    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), nope());
    }

    public void forEach(Consumer<SingleLine> singleLineConsumer) {
        lines.forEach(singleLineConsumer);
    }
}
