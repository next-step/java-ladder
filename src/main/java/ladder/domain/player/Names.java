package ladder.domain.player;

import ladder.domain.common.Point;
import ladder.domain.common.Range;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Names {
    private static final int STARTING_HEIGHT = 0;
    private static final int STARTING_POINT = 0;

    private final List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public Players toPlayers() {
        int range = names.size();

        return IntStream.range(STARTING_POINT, range)
                .mapToObj(this::makePlayer)
                .collect(collectingAndThen(toList(), Players::new));
    }

    private Player makePlayer(int index) {
        return new Player(names.get(index), new Point(index, STARTING_HEIGHT));
    }

    public Range makeRange(int height) {
        return new Range(names.size(), height);
    }
}
