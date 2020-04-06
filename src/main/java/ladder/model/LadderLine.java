package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {

    private final List<LadderBridge> bridges;

    private LadderLine(final List<LadderBridge> bridges) {
        validate(bridges);
        this.bridges = Collections.unmodifiableList(bridges);
    }

    // TODO: 2020-04-06 겹치는 구간이 없는지 validation 추가
    private void validate(final List<LadderBridge> bridges) {
        if (Objects.isNull(bridges) || bridges.isEmpty()) {
            throw new IllegalArgumentException("Ladder Bridge must be greater than zero.");
        }
    }

    public static LadderLine newInstance(final int memberCount) {
        return newInstance(MemberCount.of(memberCount));
    }

    public static LadderLine newInstance(final MemberCount memberCount) {
        List<LadderBridge> bridges = Stream.iterate(
                LadderBridge.randomBridge(),
                LadderBridge::makeRandomBridgeByPreBridge)
                .limit(memberCount.toInt() - 1)
                .collect(Collectors.toList());

        return new LadderLine(bridges);
    }

    public MemberPolePosition proceed(MemberPolePosition polePosition) {

    }

    public List<LadderBridge> getBridges() {
        return bridges;
    }

    public int getPoleCount() {
        return bridges.size() + 1;
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
