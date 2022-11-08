package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineFactory {

    private static final Random RANDOM = new Random();

    private LineFactory() {
    }

    public static Line create(final int size) {
        List<Boolean> connections = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (connections.isEmpty()) {
                connections.add(RANDOM.nextBoolean());
                continue;
            }

            if (connections.get(connections.size() - 1)) {
                connections.add(false);
                continue;
            }

            connections.add(RANDOM.nextBoolean());
        }

        return new Line(connections);
    }
}
