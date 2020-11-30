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
    private final int countOfParticipants;

    private Ladder(List<Step> ladder, int countOfParticipants) {
        this.ladder = ladder;
        this.countOfParticipants = countOfParticipants;
    }

    public static Ladder of(List<Step> ladder, int countOfParticipants) {
        return new Ladder(ladder, countOfParticipants);
    }

    public static Ladder of(int countOfSteps, int countOfParticipants, PointStrategy pointStrategy) {
        validate(countOfSteps);
        List<Step> ladder = init(countOfSteps, countOfParticipants, pointStrategy);
        return of(ladder, countOfParticipants);
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

    public TableOfResult matchTable() {
        TableOfResult tableOfResult = Stream.iterate(0, n -> n + 1)
                .limit(countOfParticipants)
                .collect(Collectors.collectingAndThen(Collectors.toList(), TableOfResult::of));

        for (int i = 0; i < ladder.size(); i++) {
            tableOfResult = ladder.get(i).move(tableOfResult);
        }

        return tableOfResult;
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
}
