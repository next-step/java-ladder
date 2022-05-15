package nextstep.ladder.domain;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public void print() {
        this.lines.forEach(Line::print);
    }
}
