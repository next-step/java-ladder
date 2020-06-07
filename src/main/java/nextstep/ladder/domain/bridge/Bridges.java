package nextstep.ladder.domain.bridge;

import nextstep.ladder.domain.Position;

import java.util.List;
import java.util.Objects;

public class Bridges {
    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public Position movePosition(Position position) {
        Bridge nextBridge = this.nextBridge(position);
        Bridge prevBridge = this.findPrevBridge(position);
        if (Objects.isNull(prevBridge)) {
            return nextBridge.isCross() ? nextBridge.getPosition().nextPosition() : position;
        }

        if (Objects.isNull(nextBridge)) {
            return prevBridge.isCross() ? prevBridge.getPosition() : position;
        }

        return nextBridge.isCross() ? nextBridge.getPosition().nextPosition() : prevBridge.isCross() ? prevBridge.getPosition() : position;
    }

    private Bridge nextBridge(Position position) {
        return bridges.stream()
                .filter(bridge -> bridge.getPosition().getPosition() == position.getPosition())
                .findFirst()
                .orElse(null);
    }

    private Bridge findPrevBridge(Position position) {
        return bridges.stream()
                .filter(prevBridge -> prevBridge.getPosition().getPosition() == position.getPosition() - 1)
                .findFirst()
                .orElse(null);
    }

    public List<Bridge> getBridges() {
        return this.bridges;
    }

    @Override
    public String toString() {
        return this.bridges.toString();
    }
}
