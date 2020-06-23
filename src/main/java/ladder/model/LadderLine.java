package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private static final int ONE = 1;

    private final List<LadderBridge> bridges;

    public LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(final List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("사다리 브릿지는 하나 이상이어야 합니다.");
        }
    }

    public static LadderLine create(final LadderBridge... bridges) {
        return new LadderLine(Arrays.asList(bridges));
    }

    public static LadderLine create(final int memberCount) {
        validate(memberCount);

        List<LadderBridge> bridges = Stream
            .iterate(LadderBridge.randomBridge(), LadderBridge::makeLadderBridgeByPreBridge)
            .limit(memberCount - ONE)
            .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    private static void validate(final int memberCount) {
        if (memberCount <= 0) {
            throw new IllegalArgumentException("참여하는 멤버는 1명 이상이어야 합니다.");
        }
    }

    public LadderPole moveLadderPole(final LadderPole ladderPole) {
        return ladderPole.move(bridges);
    }

    public int poleCount() {
        return bridges.size() + ONE;
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
