package step2.domain.ladder;

import step2.strategy.MakeLineStrategy;
import step2.strategy.PrintLadderStrategy;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Line {
    private final List<Boolean> points;

    public Line(int countOfPerson, MakeLineStrategy strategy) {
        points = strategy.create(countOfPerson);
    }

    public boolean isExistsPoint(Point targetPoint) {
        return isExistsPoint(targetPoint.getX());

    }
    public boolean isExistsPoint(int position) {
        return Optional.ofNullable(points.get(position))
                .orElse(false);

    }

    public void forEach(Consumer<Boolean> consumer) {
        points.forEach(consumer);
    }

    public String printLine(PrintLadderStrategy strategy, String delimiter) {
        String collect = points.stream()
                .map(strategy::get)
                .collect(Collectors.joining(delimiter));

        return String.format("%s%s%s", delimiter, collect, delimiter);
    }
}
