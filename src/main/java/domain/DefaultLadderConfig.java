package domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultLadderConfig implements LadderConfig {
    private int length;
    private int height;

    public DefaultLadderConfig(int length, int height) {
        this.length = length - 1;
        this.height = height;
    }

    @Override
    public List<Boolean> booleans() {
        return Stream.generate(new Random()::nextBoolean)
            .limit(length)
            .collect(Collectors.toList());
    }

    @Override
    public int height() {
        return height;
    }
}
