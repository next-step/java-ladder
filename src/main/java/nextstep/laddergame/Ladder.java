package nextstep.laddergame;

import java.util.List;
import java.util.stream.IntStream;

public record Ladder(List<Line> line) {

    public Ladder(String ladderHeight, int countOfPerson) {
        this(Integer.parseInt(ladderHeight), countOfPerson);
    }

    public Ladder(int ladderHeight, int countOfPerson) {
        this(IntStream.range(0, ladderHeight).mapToObj(i -> new Line(countOfPerson)).toList());
    }

}
