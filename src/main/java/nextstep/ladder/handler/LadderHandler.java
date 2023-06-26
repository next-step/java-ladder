package nextstep.ladder.handler;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Size;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderHandler {

    public Ladder makeLines(Size size) {
        List<Line> collect = IntStream.range(0, size.getHeight())
                .mapToObj(value -> new Line(size.getWidth()))
                .collect(Collectors.toList());
        return new Ladder(collect);

    }

    public void printLadder(Ladder ladder) {
        ladder.lines().forEach(line -> System.out.println(line.getShape()));
    }
}
