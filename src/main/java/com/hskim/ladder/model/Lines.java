package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int lineNum, int userNum, RowIndexMaker rowIndexMaker) {
        return new Lines(IntStream.range(0, lineNum)
                .mapToObj(i -> new Line(new LadderLineIterator(userNum), rowIndexMaker))
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lines)) return false;
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}
