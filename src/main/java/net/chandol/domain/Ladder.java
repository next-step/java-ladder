package net.chandol.domain;

import net.chandol.value.Positive;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;
import static net.chandol.value.Positive.pos;

public class Ladder {
    private List<Line> lines;
    private Bridges bridges;

    public Ladder(Positive lineSize, Positive height, BridgesSupplier bridgesSupplier) {
        this.lines = IntStream.range(0, lineSize.value())
                .mapToObj(i -> new Line(pos(i), height))
                .limit(lineSize.value())
                .collect(toList());

        this.bridges = bridgesSupplier.createBridges(lineSize, height);
    }

    public boolean hasBridge(Positive leftHandLine, Positive row) {
        return bridges.hasBridge(leftHandLine, row);
    }
}
