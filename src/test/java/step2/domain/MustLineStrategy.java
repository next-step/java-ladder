package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MustLineStrategy implements LineStrategy {


    @Override
    public List<Direction> createLine(int personCount) {
        return IntStream.range(0, personCount)
                .mapToObj(i -> getLine())
                .collect(Collectors.toList());
    }

    private Direction getLine() {
        return Direction.DOWN;
    }

}
