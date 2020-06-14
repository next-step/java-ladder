package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private static final int ONE = 1;

    private final List<LadderBridge> ladderBridges;

    public LadderLine(List<LadderBridge> ladderBridges) {
        this.ladderBridges = ladderBridges;
    }

    public static LadderLine create(int count) {
        List<LadderBridge> ladderBridges = Stream
            .iterate(LadderBridge.randomBridge(), LadderBridge::makeLadderBridgeByPreBridge)
            .limit(count - ONE)
            .collect(Collectors.toList());

        return new LadderLine(ladderBridges);
    }

    public List<LadderBridge> getLadderBridges() {
        return ladderBridges;
    }
}
