package ladder.domain;

import java.util.List;

public class Row {
    private final List<Bridge> bridges;

    public Row(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static int calculateMaxInstallableBridges(int players) {
        return players / 2;
    }
}
