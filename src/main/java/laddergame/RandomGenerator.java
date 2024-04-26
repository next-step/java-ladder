package laddergame;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGenerator {

    private final Random random = new Random();
    private boolean previous = random.nextBoolean();

    public List<Boolean> generator(int count) {
        return Stream.generate(this::getBoolean).limit(count)
            .collect(Collectors.toUnmodifiableList());
    }

    private boolean getBoolean() {
        if (previous) {
            previous = false;
            return false;
        }
        previous = random.nextBoolean();
        return previous;
    }

}
