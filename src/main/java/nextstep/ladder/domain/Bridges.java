package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Bridges {

    private static final Random RANDOM = new Random();
    private final List<Boolean> bridges;

    Bridges(List<Boolean> bridges) {
        this.bridges = bridges;
    }

    Bridges(int width) {
        bridges = new ArrayList<>();
        initBridge(width);
    }

    private void initBridge(int width) {
        if (width == 1) {
            appendBridge(false);
            return;
        }

       appendBridge(RANDOM.nextBoolean());
        for (int index = 1; index < width - 1; index++) {
            setBridgeAt(index);
        }
        appendBridge(false);
    }

    private void setBridgeAt(int index) {
        boolean previousBridge = bridges.get(index - 1);
        if (previousBridge) {
            appendBridge(false);
            return;
        }
        appendBridge(RANDOM.nextBoolean());
    }

    private void appendBridge(boolean bridge) {
        bridges.add(bridge);
    }

    public void apply(Participants participants) {
        IntStream.range(0, bridges.size() - 1)
                .filter(bridges::get)
                .forEach(participants::swapWithNext);
    }

    public List<Boolean> getBridges() {
        return new ArrayList<>(bridges);
    }
}
