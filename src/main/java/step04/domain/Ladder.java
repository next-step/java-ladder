package step04.domain;

import exception.InvalidCountOfStepsException;
import strategy.PointStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Step> ladder;
    private Ladder(List<Step> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(List<Step> ladder) {
        return new Ladder(ladder);
    }

    public static Ladder of(int countOfSteps, int countOfParticipants, PointStrategy pointStrategy) {
        validate(countOfSteps);
        List<Step> ladder = init(countOfSteps, countOfParticipants, pointStrategy);
        return of(ladder);
    }

    private static List<Step> init(int countOfSteps, int countOfParticipants, PointStrategy pointStrategy) {
        return Stream.generate(() -> Step.of(countOfParticipants, pointStrategy))
                .limit(countOfSteps)
                .collect(Collectors.toList());
    }

    private static void validate(int countOfSteps) {
        if (countOfSteps < 1)
            throw new InvalidCountOfStepsException();
    }

    public List<Step> getLadder() {
        return ladder.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }

    public int size() {
        return ladder.size();
    }
}
