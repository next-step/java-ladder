package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Stairs {
    private final List<Stair> stairs;

    public Stairs(final List<Stair> stair) {
        this.stairs = Collections.unmodifiableList(stair);
    }

    public int count() {
        return stairs.size();
    }
}
