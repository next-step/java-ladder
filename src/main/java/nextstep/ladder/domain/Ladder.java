package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static nextstep.ladder.domain.Direction.STAY;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int countOfPerson) {
        this.lines = Stream.generate(() -> createLine(countOfPerson))
                .limit(height.height())
                .collect(Collectors.toList());
    }

    private static Line createLine(int countOfPerson) {
        if(countOfPerson == 1){
            return new Line(STAY);
        }
        return new Line(countOfPerson);
    }

    public int climb(int position) {
        for (Line line : lines) {
            position = line.move(position).move(position);
        }
        return position;
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
