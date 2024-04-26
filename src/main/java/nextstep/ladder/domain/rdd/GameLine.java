package nextstep.ladder.domain.rdd;

import nextstep.ladder.domain.Rung;
import nextstep.ladder.interfaces.Line;

import java.util.List;

public class GameLine implements Line {
    private final List<Rung> rungs;

    public GameLine(List<Rung> rungs) {
        this.rungs = rungs;
    }

    public int size() {
        return rungs.size();
    }

    @Override
    public int move(int position) {
        return rungs.get(position).move();
    }
}
