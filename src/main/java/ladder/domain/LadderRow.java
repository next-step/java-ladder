package ladder.domain;

import java.util.Arrays;
import java.util.Random;

public class LadderRow {
    private Boolean[] connectedPoints;
    private static final Random random = new Random();

    public LadderRow(Boolean[] connectedPoints) {
        this.connectedPoints = connectedPoints;
    }

    public LadderRow(int size) {
        connectedPoints = new Boolean[size];
        connectedPoints = Arrays.stream(connectedPoints).map(point -> random.nextBoolean()).toArray(Boolean[]::new);
    }

    public int size() {
        return connectedPoints.length;
    }

    @Override
    public String toString() {
        if (connectedPoints.length == 0) {
            return "|";
        }

        return Arrays.stream(connectedPoints)
                .map(point -> (point == true) ? "|-----" : "|     ")
                .reduce((left, right) -> left + right)
                .map(row -> row + "|")
                .orElse("");
    }
}
