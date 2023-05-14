package ladder.model.ladder;

import ladder.strategy.LadderGenerationStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class LadderRow {
    private final List<Stile> stiles;

    private LadderRow(List<Stile> stiles) {
        this.stiles = Collections.unmodifiableList(stiles);
    }

    public static LadderRow create(int stiles, LadderGenerationStrategy strategy) {
        Objects.requireNonNull(strategy);

        return LadderRow.of(Stream.iterate(strategy.first(), strategy::next)
                .limit(stiles - 1)
                .toArray(Boolean[]::new)
        );
    }

    public static LadderRow of(Boolean... connections) {
        if (connections.length < 1) {
            throw new IllegalArgumentException("the length of input must be >= 1: " + connections.length);
        }

        List<Stile> stiles = createStiles(connections);

        for (int index : connectionIndexes(connections)) {
            Stile curr = stiles.get(index);
            Stile next = stiles.get(index + 1);
            Stile.connect(curr, next);
        }

        return new LadderRow(stiles);
    }

    private static List<Stile> createStiles(Boolean... connections) {
        return Stream.generate(Stile::new)
                .limit(connections.length + 1)
                .collect(toList());
    }

    private static int[] connectionIndexes(Boolean... connections) {
        return range(0, connections.length)
                .filter(index -> connections[index])
                .toArray();
    }


    public int width() {
        return stiles.size() - 1;
    }

    public List<Stile> stiles() {
        return stiles;
    }

    public int nextStile(int stileIndex) {
        Stile curr = stiles.get(stileIndex);

        if (curr.isLeftConnected()) {
            return stileIndex - 1;
        }
        if (curr.isRightConnected()) {
            return stileIndex + 1;
        }

        return stileIndex;
    }
}
