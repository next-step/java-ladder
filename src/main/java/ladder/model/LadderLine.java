package ladder.model;

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
        int polePosition = ladderPole.toInt();

        if (polePosition != 0 && bridges.get(polePosition - 1) == LadderBridge.EXIST) {
            return LadderPole.create(polePosition - 1);
        }

        if (polePosition != bridges.size() && bridges.get(polePosition) == LadderBridge.EXIST) {
            return LadderPole.create(polePosition + 1);
        }

        return LadderPole.create(polePosition);
    }

    public int poleCount() {
        return bridges.size() + 1;
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
