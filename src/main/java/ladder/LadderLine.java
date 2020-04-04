package ladder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    private void validate(List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
        }
    }

    public static LadderLine newInstance(int memberCount) {
        return newInstance(new MemberCount(memberCount));
    }

    public static LadderLine newInstance(final MemberCount memberCount) {
        List<LadderBridge> bridges = Stream.iterate(
                LadderBridge.randomBridge(),
                LadderBridge::makeRandomBridge)
                .limit(memberCount.toInt() - 1)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderLine)) return false;
        LadderLine that = (LadderLine) o;
        return Objects.equals(getBridges(), that.getBridges());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBridges());
    }
}
