package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private List<Cross> crosses;

    public Line(final List<Cross> crosses) {
        this.crosses = crosses;
    }

    public int move(final int position) {
        return crosses.get(position).move();
    }
}
