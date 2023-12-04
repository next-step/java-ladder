package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lines implements Iterable<Line> {
    private final List<Line> lines;

    public Lines() {
        this.lines = new ArrayList<>();
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    @Override
    public Iterator<Line> iterator() {
        return this.lines.iterator();
    }

    public void add(Line line) {
        this.lines.add(line);
    }

    public int size() {
        return this.lines.size();
    }
}
