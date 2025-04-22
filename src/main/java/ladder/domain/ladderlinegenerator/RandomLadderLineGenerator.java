package ladder.domain.ladderlinegenerator;

import ladder.domain.LadderLineGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderLineGenerator implements LadderLineGenerator {

    public static final double RANDOM_TRUE_THRESHOLD = 0.5;

    public RandomLadderLineGenerator() {}

    public List<Boolean> generateLadderLine(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("사다리의 길이는 0 이상이어야 합니다.");
        }

        AtomicBoolean previousValue = new AtomicBoolean(false);

        return IntStream.range(0, size)
                .mapToObj(i -> determineNextValue(previousValue))
                .collect(Collectors.toList());
    }

    private boolean determineNextValue(AtomicBoolean previousValue) {
        boolean currentValue = Math.random() > RANDOM_TRUE_THRESHOLD;
        if (previousValue.get() && currentValue) {
            currentValue = false;
        }
        previousValue.set(currentValue);
        return currentValue;
    }

}
