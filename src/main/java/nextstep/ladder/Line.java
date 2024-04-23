package nextstep.ladder;

import java.util.List;

public class Line {
    private final int countOfPeople;
    private final List<Rung> rungs;

    public Line(int countOfPeople, List<Rung> rungs) {
        this.countOfPeople = countOfPeople;
        this.rungs = rungs;
    }

    public int move(int position) {
        return rungs.get(position).move();
    }
}
