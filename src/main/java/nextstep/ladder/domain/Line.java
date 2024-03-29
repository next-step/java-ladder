package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final Generator generator, final int numberOfPeople) {
        while (bridges.size() < numberOfPeople - 1) {
            final boolean now = generator.generate();
            addBridge(Bridge.of(now));
        }
    }

    private void addBridge(final Bridge now) {
        if (bridges.isEmpty()) {
            bridges.add(now);
            return;
        }
        if (bridges.get(bridges.size() - 1).isBridge()) {
            bridges.add(Bridge.of(false));
            return;
        }
        bridges.add(now);
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
