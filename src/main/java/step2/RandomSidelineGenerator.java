package step2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomSidelineGenerator implements SidelineGenerator {
    private final static Random RANDOM = new Random();

    @Override
    public List<Boolean> generate(int n) {
        return Stream.generate(RANDOM::nextBoolean)
                .limit(n)
                .collect(Collectors.toList());
    }
}
