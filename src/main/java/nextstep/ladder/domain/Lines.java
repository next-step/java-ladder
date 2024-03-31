package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    private Lines(Floor floor, int countOfUsers, LineStrategy strategy) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < floor.getFloor(); i++) {
            lines.add(strategy.execute(countOfUsers));
        }
    }

    public static Lines of(Floor floor, int countOfUsers, LineStrategy strategy) {
        return new Lines(floor, countOfUsers, strategy);
    }

    public List<List<StepType>> toList() {
        return lines.stream()
                .map(Line::toList)
                .collect(Collectors.toList());
    }
}
