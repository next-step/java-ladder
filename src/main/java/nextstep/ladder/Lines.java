package nextstep.ladder;

import nextstep.ladder.domain.Line;

import java.util.List;

public class Lines {

    private final List<Line> values;

    public Lines(List<Line> values) {
        this.values = values;
    }

    public int finalPosition(int startPosition) {
        return 1;
    }
}
