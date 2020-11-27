package step2.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
    private final Random random = new Random();
    private boolean previousLadder = false;

    @Override
    public List<Boolean> createLine(int personCount) {
        return IntStream.range(0, personCount)
                .mapToObj(this::randomLine)
                .collect(Collectors.toList());
    }

    private Boolean randomLine(int position) {
        if (previousLadder) {
            previousLadder = false;
            return false;
        }

        previousLadder = random.nextBoolean();
        return previousLadder;
    }
}
