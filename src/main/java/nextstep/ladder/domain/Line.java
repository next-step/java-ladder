package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MOVE_LEFT = -1;
    private static final int NO_MOVE = 0;
    private static final int MOVE_RIGHT = 1;

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final Generator generator, final int numberOfPeople) {
        while (bridges.size() < numberOfPeople - 1) {
            final boolean now = generator.generate();
            addBridge(Bridge.of(now));
        }
    }

    public int move(final int column) {
        final Bridge leftBridge = getBridge(column - 1);
        final Bridge rightBridge = getBridge(column);

        if (leftBridge.isBridge()) {
            return MOVE_LEFT;
        }
        if (rightBridge.isBridge()) {
            return MOVE_RIGHT;
        }
        return NO_MOVE;
    }

    private void addBridge(final Bridge now) {
        if (bridges.isEmpty()) {
            bridges.add(now);
            return;
        }
        if (getBridge(bridges.size() - 1).isBridge()) {
            bridges.add(Bridge.of(false));
            return;
        }
        bridges.add(now);
    }

    private Bridge getBridge(final int index) {
        if (index >= 0 && index < bridges.size()) {
            return bridges.get(index);
        }
        return Bridge.NON_BRIDGE;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
