package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> bridges;

    Line(List<Boolean> bridges) {
        validateBridge(bridges);
        this.bridges = bridges;
    }

    private void validateBridge(List<Boolean> bridges) {
        IntStream.range(0, bridges.size() - 1)
                .forEach(index -> {
                    boolean currentBridge = bridges.get(index);
                    boolean nextBridge = bridges.get(index + 1);
                    if (currentBridge && nextBridge) {
                        throw new IllegalArgumentException("bridges can't be next to each other. index: " + index);
                    }
                });

        boolean lastBridge = bridges.get(bridges.size() - 1);
        if (lastBridge) {
            throw new IllegalArgumentException("last bridge must be empty");
        }
    }

    static Line ofWidth(int width) {
        return new Line(BridgeFactory.createBridgeOfWidth(width));
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
