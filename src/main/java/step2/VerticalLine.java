package step2;

import java.util.List;
import java.util.stream.Collectors;

class VerticalLine extends Line {
    VerticalLine(final List<Dot> dots) {
        super(dots);
    }

    @Override
    public String print() {
        return dots.stream()
                   .map(Dot::print)
                   .collect(Collectors.joining("\n"));
    }
}
