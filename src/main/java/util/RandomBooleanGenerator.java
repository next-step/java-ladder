package util;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomBooleanGenerator implements BooleanGenerator{
    private Random random = new Random();

    @Override
    public Boolean generate() {
        return random.nextBoolean();
    }

    @Override
    public List<Boolean> generate(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> generate())
            .collect(Collectors.toList());
    }
}
