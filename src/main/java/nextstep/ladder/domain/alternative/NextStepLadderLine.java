package nextstep.ladder.domain.alternative;

import nextstep.ladder.domain.LadderLines;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static nextstep.ladder.utils.BinaryOperators.nope;

public class NextStepLadderLine implements LadderLines {
    private final List<LadderLine> lines;

    public NextStepLadderLine(int size, int height) {
        ensure(size, height);
        lines = IntStream.range(0, height)
                .mapToObj(__ -> LadderLine.of(size))
                .collect(toList());
    }

    @Override
    public int move(int index) {
        return lines.stream()
                .reduce(index, (position, line) -> line.move(position), nope());
    }

    @Override
    public void forEach(Consumer<List<Boolean>> singleLineConsumer) {
        lines.stream()
                .map(LadderLine::toMovableList)
                .forEach(singleLineConsumer);
    }
}
