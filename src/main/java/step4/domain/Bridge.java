package step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import step4.utils.RandomGenerator;

public class Bridge {

    private final boolean isOpen;

    public Bridge(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public static Bridge closed() {
        return new Bridge(false);
    }

    public static Bridge from(Bridge bridge) {
        if (bridge.isOpen()) {
            return Bridge.closed();
        }

        return new Bridge(RandomGenerator.generate());
    }

    public static List<Bridge> createClosedBridges(int count) {
        return IntStream.range(0, count)
            .mapToObj(i -> Bridge.closed())
            .collect(Collectors.toList());
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isDuplicatedBridge(Bridge bridge) {
        return isOpen && bridge.isOpen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Bridge)) {
            return false;
        }

        Bridge bridge = (Bridge) o;

        return isOpen == bridge.isOpen;
    }

    @Override
    public int hashCode() {
        return (isOpen ? 1 : 0);
    }
}