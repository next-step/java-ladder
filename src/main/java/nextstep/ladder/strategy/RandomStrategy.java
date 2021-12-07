package nextstep.ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomStrategy implements LadderStrategy {
    private static final Random RANDOM = new Random();
    private static int RANDOM_END = 10;
    private static int RANDOM_BOUNDARY = 5;

    @Override
    public List<Boolean> makeLadder(int size) {
        List<Boolean> line = new ArrayList<>();
        int initialRandomNumber = RANDOM.nextInt(RANDOM_END);
        if (initialRandomNumber >= RANDOM_BOUNDARY) {
            line.add(true);
        }
        if (initialRandomNumber < RANDOM_BOUNDARY) {
            line.add(false);
        }
        IntStream.range(1, size - 1).
                forEach(index -> {
                    int randomNumber = RANDOM.nextInt(RANDOM_END);
                    if (randomNumber >= RANDOM_BOUNDARY && line.get(index - 1) == false) {
                        line.add(true);
                    }
                    if (randomNumber < RANDOM_BOUNDARY || line.get(index - 1) == true) {
                        line.add(false);
                    }
                });
        return line;
    }
}
