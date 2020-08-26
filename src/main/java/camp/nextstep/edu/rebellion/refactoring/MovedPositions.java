package camp.nextstep.edu.rebellion.refactoring;

import java.util.Collections;
import java.util.List;

public class MovedPositions {
    private final List<MovedPosition> positions;

    public MovedPositions(List<MovedPosition> positions) {
        this.positions = positions;
    }

    public List<MovedPosition> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
