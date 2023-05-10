package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int numOfUsers, int height) {
        this.ladder = IntStream.range(0, height)
                .mapToObj(i -> new Line(numOfUsers)).collect(Collectors.toList());
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
