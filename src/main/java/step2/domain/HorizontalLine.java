package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

class HorizontalLine extends Line {
    HorizontalLine(final List<Dot> dots) {
        super(dots);
    }

    @Override
    public String print() {
        return dots.stream()
                   .map(Dot::print)
                   .collect(Collectors.joining());
    }
}
