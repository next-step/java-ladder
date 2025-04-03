package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {
    private final List<List<Boolean>> ladders;

    public Ladders(int height, int width, LineGenerator generator) {
        validLadderHeight(height);
        this.ladders = createLadders(height, width, generator);
    }

    private void validLadderHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("The ladder height should be larger than zero.");
    }

    private List<List<Boolean>> createLadders(int height, int width, LineGenerator generator) {
        return IntStream.range(0, height)
                .mapToObj(i -> createLines(width, generator))
                .collect(Collectors.toList());
    }

    private List<Boolean> createLines(int width, LineGenerator generator) {
        List<Boolean> lines = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            boolean connected = generator.isConnected();
            lines.add(connected);
            if (connected && i < width) {
                lines.add(false);
                i++;
            }
        }
        return lines;
    }

    public List<List<Boolean>> get() {
        return Collections.unmodifiableList(ladders);
    }
}
