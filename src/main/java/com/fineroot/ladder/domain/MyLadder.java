package com.fineroot.ladder.domain;

import com.fineroot.ladder.engine.Ladder;
import com.fineroot.ladder.engine.Line;
import com.fineroot.ladder.engine.Position;
import com.fineroot.ladder.engine.Positions;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MyLadder implements Ladder {

    private final List<Line> lineList;
    private final int userCount;

    MyLadder(final List<Line> lineList, final int userCount) {
        this.lineList = lineList;
        this.userCount = userCount;
    }

    @Override
    public Positions playResult() {
        return Positions.from(IntStream.range(0, userCount)
                .mapToObj(i -> calculateResultPosition(new Position(i)))
                .collect(Collectors.toList()));
    }

    private Position calculateResultPosition(final Position position) {
        return lineList.stream()
                .reduce(position, (result, myLine) -> myLine.move(result), (a, b) -> b);
    }

    @Override
    public String toString() {
        return lineList.stream()
                .map(e -> " ".repeat(4).concat(e.toString().concat(System.lineSeparator())))
                .collect(Collectors.joining()).stripTrailing();
    }
}
