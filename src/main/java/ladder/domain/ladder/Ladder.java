package ladder.domain.ladder;

import ladder.domain.play.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private final Items items;
    private List<FootStep> footSteps = new ArrayList<>();

    private Ladder(int height, Items items) {
        validate(height);
        this.items = items;
        createFootSteps(height);
    }

    private void createFootSteps(int height) {
        IntStream.range(0, height)
                .forEach(i -> this.footSteps.add(FootStep.of(this.items.getCountOfItems())));
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Ladder of(int height, Items items) {
        return new Ladder(height, items);
    }

    public int getFootStepSize() {
        return footSteps.size();
    }

    @Override
    public String toString() {
        return this.items.toString() +
                "\n" +
                this.footSteps.stream()
                        .map(FootStep::toString)
                        .collect(Collectors.joining("\n"));
    }
}
