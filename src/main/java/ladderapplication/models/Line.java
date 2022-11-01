package ladderapplication.models;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private final List<Boolean> hasSteps;

    private Line(List<Boolean> hasSteps) {
        this.hasSteps = hasSteps;
    }

    public static Line of(int playerCount) {
        List<Boolean> hasSteps = Stream.generate(() -> Boolean.FALSE)
                .limit(playerCount - 1)
                .collect(Collectors.toList());

        IntStream.range(0, hasSteps.size())
                .forEach(index -> {
                    if ((index == 0 || !hasSteps.get(index - 1)) && hasStep()) {
                        hasSteps.set(index, Boolean.TRUE);
                    }
                });
        return new Line(hasSteps);
    }

    private static boolean hasStep() {
        return RANDOM_GENERATOR.nextInt(RANDOM_NUMBER_BOUND) >= 3;
    }

    public String getLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        hasSteps.forEach(hasStep -> {
            if (hasStep) {
                sb.append("|-----");
                return;
            }

            sb.append("|     ");
        });

        sb.append("|");
        return sb.toString();
    }
}
