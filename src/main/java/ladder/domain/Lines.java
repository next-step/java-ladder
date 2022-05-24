package ladder.domain;

import ladder.view.Output;

import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> lines() {
        return this.lines;
    }
}
