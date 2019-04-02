package generator.ladder.impl;

import domain.ladder.Ladder;
import domain.ladder.Ladders;
import generator.ladder.LaddersGenerator;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLineLaddersGenerator implements LaddersGenerator {

    BooleanSupplier booleanGenerator;

    public RandomLineLaddersGenerator(BooleanSupplier booleanSupplier) {
        this.booleanGenerator = booleanSupplier;
    }

    @Override
    public Ladders generate(int height, int size) {
        List<Ladder> ladders = IntStream.range(0, height)
                .mapToObj(i -> new Ladder(size, booleanGenerator))
                .collect(Collectors.toList());

        return new Ladders(ladders);
    }
}
