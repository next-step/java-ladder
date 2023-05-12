package ladder.model.ladder;

import ladder.strategy.LadderGenerationStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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

        List<Stile> result = Stream.generate(Stile::new)
                .limit(connections.length + 1)
                .collect(toList());

        connectStiles(result, connections);

        return new LadderRow(result);
    }

    private static void connectStiles(List<Stile> result, Boolean... connections) {
        IntStream.range(0, connections.length)
                .filter(index -> connections[index])
                .forEach(index -> {
                    Stile curr = result.get(index);
                    Stile next = result.get(index + 1);
                    Stile.connect(curr, next);
                });
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
