package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Stream;

public class RowLine {
    private final List<Step> line;

    protected RowLine(List<Step> line) {
        this.line = line;
    }

    public static RowLine from(List<Step> line) {
        return new RowLine(line);
    }

    public int lineSize() {
        return line.size();
    }

    public Stream<Step> line() {
        return this.line.stream();
    }

    public Step step(int index) {
        return line.get(index);
    }
}
