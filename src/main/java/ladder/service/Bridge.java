package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Bridge {
    private static final Random RANDOM = new Random();

    private final List<Boolean> connections = new ArrayList<>();

    public Bridge(int participantCount) {
        connectLadders(participantCount);
    }

    private void connectLadders(int participantCount) {
        IntStream.range(0, participantCount - 1)
                .forEach(index -> {
                    if (index > 0 && !connections.isEmpty() && connections.get(index - 1)) {
                        connections.add(false);
                        return;
                    }
                    connections.add(RANDOM.nextBoolean());
                });
    }

    public List<Boolean> getConnections() {
        return connections;
    }

}
