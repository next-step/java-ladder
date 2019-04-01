package generator.ladder.impl;

import domain.ladder.Ladder;
import domain.ladder.Ladders;
import generator.ladder.LaddersGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixingLineLaddersGenerator implements LaddersGenerator {

    @Override
    public Ladders generate(int height, int size) {
        return new Ladders(IntStream.range(0, height)
                .mapToObj(i -> new Ladder(size, () -> true))
                .collect(Collectors.toList()));
    }
}
