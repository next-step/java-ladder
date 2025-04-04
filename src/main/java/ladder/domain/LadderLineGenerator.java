package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineGenerator {
    
    private LadderLineGenerator() {}

    public static List<Boolean> generateLadderLine(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("사다리의 길이는 1 이상이어야 합니다.");
        }

        AtomicBoolean previousValue = new AtomicBoolean(false);

        return IntStream.range(0, size)
                .mapToObj(i -> determineNextValue(previousValue))
                .collect(Collectors.toList());
    }

    private static boolean determineNextValue(AtomicBoolean previousValue) {
        boolean currentValue = Math.random() > 0.5;
        if (previousValue.get() && currentValue) {
            currentValue = false;
        }
        previousValue.set(currentValue);
        return currentValue;
    }

}
