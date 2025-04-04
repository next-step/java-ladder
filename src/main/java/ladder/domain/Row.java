package ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private final List<Bridge> bridges;

    public Row(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static int calculateMaxInstallableBridges(int players) {
        return players / 2;
    }

    public static boolean isInstallable(List<Bridge> bridges) {
        return IntStream.range(0, bridges.size() - 1)
                .noneMatch(i -> bridges.get(i).isContinuous(bridges.get(i + 1)));
    }


}
