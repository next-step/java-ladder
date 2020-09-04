package com.hskim.ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int lineNum, int userNum, RowIndexMaker rowIndexMaker) {
        return new Lines(Collections.unmodifiableList(
                IntStream.range(0, lineNum)
                        .mapToObj(i -> new Line(new LadderLineIterator(userNum), rowIndexMaker))
                        .collect(Collectors.toList())
        ));
    }

    public List<List<LadderPoint>> getLines() {
        return lines.stream()
                .map(Line::getLadderPoints)
                .collect(Collectors.toList());
    }

    public List<RouteInfo<Integer>> getRouteInfoList() {
        return lines.stream()
                .map(Line::getRouteInfo)
                .collect(Collectors.toList());
    }

    public boolean isEmpty() {
        return lines.isEmpty();
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
