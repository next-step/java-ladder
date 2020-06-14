package ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private static final int ONE = 1;

    private final List<LadderBridge> bridges;

    public LadderLine(List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("사다리 브릿지는 하나 이상이어야 합니다.");
        }
    }

    public static LadderLine create(int memberCount) {
        validate(memberCount);

        List<LadderBridge> bridges = Stream
            .iterate(LadderBridge.randomBridge(), LadderBridge::makeLadderBridgeByPreBridge)
            .limit(memberCount - ONE)
            .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    private static void validate(int memberCount) {
        if (memberCount <= 0) {
            throw new IllegalArgumentException("참여하는 멤버는 1명 이상이어야 합니다.");
        }
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }
}
