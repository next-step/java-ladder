package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final List<Line> lines;

    public static Lines of(Floor floor, int countOfUsers, StepStrategy strategy) {
        return new Lines(floor, countOfUsers, strategy);
    }

    private Lines(Floor floor, int countOfUsers, StepStrategy strategy) {
        this.lines = IntStream.range(0, floor.getFloor())
                .mapToObj(index ->
                        Line.of(countOfUsers, strategy)
                ).collect(Collectors.toList());
    }

    public List<List<StepType>> toList() {
        return lines.stream()
                .map(Line::toList)
                .collect(Collectors.toList());
    }
}
