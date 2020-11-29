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
    private final List<Integer> resultTable;

    private Ladder(List<Step> ladder, List<Integer> resultTable) {
        this.ladder = ladder;
        this.resultTable = resultTable;
    }

    public static Ladder of(List<Step> ladder, List<Integer> resultTable) {
        return new Ladder(ladder, resultTable);
    }

    public static Ladder of(int countOfSteps, int countOfParticipants, PointStrategy pointStrategy) {
        validate(countOfSteps);
        List<Step> ladder = init(countOfSteps, countOfParticipants, pointStrategy);
        List<Integer> resultTable = matchTable(ladder, countOfParticipants);
        return of(ladder, resultTable);
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

    private static List<Integer> matchTable(List<Step> ladder, int countOfParticipants) {
        List<Integer> table = Stream.iterate(0, n -> n + 1)
                .limit(countOfParticipants)
                .collect(Collectors.toList());
        ladder.forEach(step -> moveStep(table, step.getPoints()));

        return table;
    }

    private static void moveStep(List<Integer> table, List<Point> points) {
        for (int index = 0; index < points.size(); index++) {
            swapIndex(table, index, points.get(index));
        }
    }

    private static void swapIndex(List<Integer> table, int index, Point point) {
        if (!point.hasLine()) {
            return;
        }

        int temp1 = table.get(index);
        int temp2 = table.get(index + 1);
        table.set(index, temp2);
        table.set(index + 1, temp1);
    }

    public List<Integer> getResultTable() {
        return resultTable.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
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
