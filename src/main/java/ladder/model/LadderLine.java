package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    public static LadderLine newInstance(final LadderBridge... bridges) {
        return new LadderLine(Arrays.asList(bridges));
    }

    private void validate(final List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
        }

        validateConsecutiveLines(bridges);
    }

    private void validateConsecutiveLines(final List<LadderBridge> bridges) {
        LadderBridge preBridge = LadderBridge.UN_EXIST;

        for (LadderBridge bridge : bridges) {
            validateConsecutiveBridges(preBridge, bridge);
            preBridge = bridge;
        }
    }

    private void validateConsecutiveBridges(final LadderBridge preBridge, final LadderBridge bridge) {
        if (preBridge == bridge && preBridge == LadderBridge.EXIST) {
            throw new IllegalArgumentException("Ladder Bridge can not set to consecutive.");
        }
    }

    public static LadderLine newInstance(final int poleCount) {
        return newInstance(PoleCount.of(poleCount));
    }

    public static LadderLine newInstance(final PoleCount poleCount) {
        List<LadderBridge> bridges = Stream.iterate(
                LadderBridge.randomBridge(),
                LadderBridge::makeRandomBridgeByPreBridge)
                .limit(poleCount.toInt() - 1)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    public LadderPole moveLadderPole(final LadderPole ladderPole) {
        int polePosition = ladderPole.toInt();

        if (polePosition != 0 && bridges.get(polePosition - 1) == LadderBridge.EXIST) {
            return LadderPole.of(polePosition - 1);
        }

        if (polePosition != bridges.size() && bridges.get(polePosition) == LadderBridge.EXIST) {
            return LadderPole.of(polePosition + 1);
        }

        return LadderPole.of(polePosition);
    }

    public int poleCount() {
        return bridges.size() + 1;
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
