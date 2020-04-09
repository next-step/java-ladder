package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    public static LadderLine newInstance(LadderBridge... bridges) {
        return new LadderLine(Arrays.asList(bridges));
    }

    private void validate(final List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
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

    public LadderMoveDirections proceed() {
        List<LadderMoveDirection> ladderMoveDirections = IntStream.rangeClosed(0, bridges.size())
                .mapToObj(this::findLadderMoveDirection)
                .collect(Collectors.toList());
        return LadderMoveDirections.newInstance(ladderMoveDirections);
    }

    private LadderMoveDirection findLadderMoveDirection(final int polePosition) {
        if (polePosition != 0 && bridges.get(polePosition - 1) == LadderBridge.EXIST) {
            return LadderMoveDirection.LEFT;
        }

        if (polePosition != bridges.size() && bridges.get(polePosition) == LadderBridge.EXIST) {
            return LadderMoveDirection.RIGHT;
        }

        return LadderMoveDirection.STAY;
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
