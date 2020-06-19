package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private List<FootStep> footSteps = new ArrayList<>();

    private Ladder(int height, int countOfUser) {
        validate(height);
        IntStream.range(0, height)
                .forEach(i -> this.footSteps.add(FootStep.of(countOfUser)));
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Ladder of(int height, int countOfUser) {
        return new Ladder(height, countOfUser);
    }

    public int getFootStepSize() {
        return footSteps.size();
    }

    @Override
    public String toString() {
        return this.footSteps.stream()
                .map(FootStep::toString)
                .collect(Collectors.joining());
    }
}
