package domain;

import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {
    private final List<Line> lines;
    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public LadderResult play(Players players, List<String> results) {
        return players.play(lines, results);
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
