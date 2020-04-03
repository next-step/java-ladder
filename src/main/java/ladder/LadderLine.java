package ladder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
        }
    }

    public static LadderLine newInstance(final int memberCount) {
        List<LadderBridge> bridges = Stream.iterate(
                LadderBridge.UN_EXIST,
                bridge -> LadderBridge.makeRandomBridge(Optional.ofNullable(bridge)))
                .limit(memberCount)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

}
