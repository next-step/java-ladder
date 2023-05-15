package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineRandom {

    private static Random random;

    public LineRandom(Random random) {
        this.random = random;
    }

    public static LineRandom of(Random random) {
        return new LineRandom(random);
    }

    public List<Boolean> randomList(int size) {
        return Stream.iterate(randomPoint(), this::nextPoint)
            .limit(size)
            .collect(Collectors.toList());
    }

    public Boolean nextPoint(Boolean prev) {
        if (prev.equals(Boolean.TRUE)) {
            return Boolean.FALSE;
        }
        return randomPoint();
    }

    private boolean randomPoint() {
        return random.nextBoolean();
    }

}
