package ladder.domain.ladderlinegenerator;

import ladder.domain.LadderLineGenerator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.LadderConstants.RANDOM_TRUE_THRESHOLD;

public class RandomLadderLineGenerator implements LadderLineGenerator {

    public RandomLadderLineGenerator() {}

    public List<Boolean> generateLadderLine(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("사다리의 길이는 1 이상이어야 합니다.");
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
