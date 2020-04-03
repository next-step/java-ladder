package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        this.bridges = bridges;
    }

    public static LadderLine newInstance(final int memberCount) {
        List<LadderBridge> bridges = Stream.iterate(LadderBridge.UN_EXIST, LadderBridge::makeRandomBridge)
                .limit(memberCount)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

}
