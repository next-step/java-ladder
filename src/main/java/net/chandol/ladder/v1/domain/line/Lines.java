package net.chandol.ladder.v1.domain.line;

import net.chandol.ladder.v1.domain.bridge.Bridges;
import net.chandol.ladder.v1.domain.player.Players;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lines implements Iterable<Line> {
    private List<Line> lines;

    public Lines(Players players, Bridges bridges) {
        this.lines = IntStream.range(0, players.size())
                .mapToObj(idx -> new Line(idx, players.getPlayer(idx), bridges))
                .collect(toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public Iterator<Line> iterator() {
        return this.lines.iterator();
    }

    public int size() {
        return lines.size();
    }
}
