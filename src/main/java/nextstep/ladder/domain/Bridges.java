package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bridges {

    private static final Random RANDOM = new Random();

    private final List<Boolean> bridges = new ArrayList<>();

    Bridges(int width) {
        initBridge(width);
    }

    private void initBridge(int width) {
        if (width == 1) {
            bridges.add(false);
            return;
        }

        bridges.add(RANDOM.nextBoolean());
        for (int i = 1; i < width - 1; i++) {
            addBridge(i);
        }
        bridges.add(false);
    }

    private void addBridge(int index) {
        if (bridges.get(index - 1)) {
            bridges.add(false);
            return;
        }
        bridges.add(RANDOM.nextBoolean());
    }

    public List<Boolean> getBridges() {
        return new ArrayList<>(bridges);
    }
}
