package nextstep.ladder.domain;

import nextstep.ladder.utils.BinaryOperators;

import java.util.Arrays;
import java.util.List;

class Lines implements LineIF {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static LineIF of(Line... lines) {
        return new Lines(Arrays.asList(lines));
    }

    @Override
    public Position moveOn(Position from) {
        return lines.stream()
                .reduce(from, (position, line) -> line.moveOn(position), BinaryOperators.nope());
    }
}
