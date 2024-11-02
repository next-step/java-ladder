package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        ladder = Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return this.ladder;
    }
}
