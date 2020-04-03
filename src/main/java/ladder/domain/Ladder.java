package ladder.domain;

import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }
}
