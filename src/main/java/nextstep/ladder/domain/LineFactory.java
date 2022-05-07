package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final Random RANDOM = new Random();

    private LineFactory() {
        throw new UnsupportedOperationException();
    }

    static Line createLineOfWidth(int width) {
        List<Boolean> bridges = new ArrayList<>();
        addRandomBridge(bridges, width);
        removeInvalidBridge(bridges, width);
        return new Line(bridges);
    }

    private static void addRandomBridge(List<Boolean> bridges, int width) {
        for (int index = 0; index < width; index++) {
            bridges.add(RANDOM.nextBoolean());
        }
    }

    private static void removeInvalidBridge(List<Boolean> bridges, int width) {
        for (int index = 1; index < width; index++) {
            removeInvalidBridgeAt(bridges, index);
        }
        bridges.set(width - 1, false);
    }

    private static void removeInvalidBridgeAt(List<Boolean> bridges, int index) {
        boolean previousBridge = bridges.get(index - 1);
        if (previousBridge) {
            bridges.set(index, false);
        }
    }
}
