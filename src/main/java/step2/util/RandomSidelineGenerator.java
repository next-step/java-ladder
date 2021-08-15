package step2.util;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomSidelineGenerator implements SidelineGenerator {
    private final static Random RANDOM = new Random();

    private final int length;

    public RandomSidelineGenerator(int length) {
        this.length = length;
    }
    @Override
    public List<Boolean> generate() {
        return Stream.generate(RANDOM::nextBoolean)
                .limit(length)
                .collect(Collectors.toList());
    }
}
