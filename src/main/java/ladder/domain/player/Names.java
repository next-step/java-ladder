package ladder.domain.player;

import ladder.domain.common.Height;
import ladder.domain.common.Point;
import ladder.domain.common.Range;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Names {
    private static final int STARTING_HEIGHT = 0;
    private static final int STARTING_POINT = 0;

    private final List<Name> names;

    public Names(String[] names) {
        this.names = Arrays.stream(names)
                .map(Name::new)
                .collect(toList());
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

    public Range makeRange(Height height) {
        return new Range(names.size(), height);
    }
}
