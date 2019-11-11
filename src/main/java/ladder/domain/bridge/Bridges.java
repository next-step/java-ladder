package ladder.domain.bridge;

import java.util.Collections;
import java.util.List;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
