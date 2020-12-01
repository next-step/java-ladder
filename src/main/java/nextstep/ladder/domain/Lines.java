package nextstep.ladder.domain;

import nextstep.ladder.utils.BinaryOperators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Lines implements Line {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Line of(Line... lines) {
        return new Lines(Arrays.asList(lines));
    }

    public static Line of(Spoke... spokes) {
        return new Lines(Stream.of(spokes).map(Spoke::toLine).collect(toList()));
    }

    @Override
    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), BinaryOperators.nope());
    }
}
