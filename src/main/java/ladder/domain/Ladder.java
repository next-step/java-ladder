package ladder.domain;

import lombok.Getter;

import java.util.List;

public class Ladder {
    @Getter
    private List<Line> lines;

    public Ladder(int userCount, int height) {
        this.lines = Line.listOf(userCount, height);
    }
}
