package ladder.domain.line;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineRandom implements LineStrategy {

    private final Random random;

    public LineRandom(Random random) {
        this.random = random;
    }

    public static LineRandom of(Random random) {
        return new LineRandom(random);
    }

    @Override
    public List<Boolean> listSizeOf(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> randomBoolean())
            .collect(Collectors.toList());
    }

    private Boolean randomBoolean() {
        return random.nextBoolean();
    }

}
