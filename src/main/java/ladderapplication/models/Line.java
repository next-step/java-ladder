package ladderapplication.models;

import ladderapplication.utils.DecoratingUtils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Line {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int HAS_STEP_BOUND = 4;
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
                .forEach(index -> setHasStep(hasSteps, index));

        return new Line(hasSteps);
    }

    private static void setHasStep(List<Boolean> hasSteps, int index) {
        if (prevLadderHasNotStep(hasSteps, index) && hasStep()) {
            hasSteps.set(index, Boolean.TRUE);
        }
    }

    private static boolean prevLadderHasNotStep(List<Boolean> hasSteps, int index) {
        return index == 0 || !hasSteps.get(index - 1);
    }

    private static boolean hasStep() {
        return RANDOM_GENERATOR.nextInt(RANDOM_NUMBER_BOUND) >= HAS_STEP_BOUND;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        hasSteps.forEach(hasStep -> {
            sb.append("|")
                    .append(DecoratingUtils.getStep(hasStep));
        });

        sb.append("|");
        return sb.toString();
    }
}
