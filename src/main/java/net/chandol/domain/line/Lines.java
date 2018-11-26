package net.chandol.domain.line;

import net.chandol.value.Positive;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static net.chandol.value.Positive.pos;

public class Lines {
    private List<Line> lines;

    public Lines(Positive lineSize, Positive height) {
        this.lines = IntStream.range(0, lineSize.value())
                .mapToObj(i -> new Line(pos(i), height))
                .limit(lineSize.value())
                .collect(toList());
    }
}
