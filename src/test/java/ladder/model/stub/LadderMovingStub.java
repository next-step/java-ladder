package ladder.model.stub;

import ladder.model.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderMovingStub implements MoveStrategy {

    private List<List<Boolean>> lines;
    private int now;

    public LadderMovingStub() {
        this.now = 0;
        lines = new ArrayList<>();
        lines.add(Arrays.asList(false, true, false));
        lines.add(Arrays.asList(false, false, true));
        lines.add(Arrays.asList(false, true, false));
    }

    @Override
    public List<Boolean> generate(int size) {
        return lines.get(now++);
    }
}
