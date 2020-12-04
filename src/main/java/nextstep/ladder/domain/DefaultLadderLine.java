package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class DefaultLadderLine implements LadderLines {
    private static final Random RANDOM = new Random();
    private final List<Line> lines;

    public DefaultLadderLine(int width, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(__ -> Spoke.fromCount(width - 1, RANDOM::nextBoolean))
                .map(Line::new)
                .collect(toList());
    }

    public DefaultLadderLine(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public int move(int index) {
        return lines.stream()
                .reduce(Position.of(index), (position, line) -> line.moveOn(position), nope())
                .toInt();
    }

    @Override
    public void forEach(Consumer<List<Boolean>> singleLineConsumer) {
        lines.forEach(line -> singleLineConsumer.accept(line.toSpokeList()));
    }
}
