package nextstep.ladder.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Lines> linesList;

    public Ladder(List<Lines> lines) {
        this.linesList = lines;
    }

    public List<Lines> getLinesList() {
        return linesList;
    }

    public Ladder(int userCount , int ladderHeight) {
        this(lines(userCount, ladderHeight));
    }

    private static List<Lines> lines(int userCount, int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(ladderIndex -> new Lines(userCount))
                .collect(Collectors.toList());
    }
}
