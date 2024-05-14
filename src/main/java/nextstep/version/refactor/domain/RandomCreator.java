package nextstep.version.refactor.domain;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomCreator implements LineCreator {
    private static final Random RANDOM = new Random();

    @Override
    public Boolean[] createBooleanList(int size) {
        Boolean[] result = new Boolean[size];
        IntStream.range(0, size)
                .forEach(i -> {
                    result[i] = createRandomLadder(i, result);
                });
        return result;
    }

    private static boolean createRandomLadder(int i, Boolean[] result) {
        if (i == 0) {
            return (RANDOM.nextInt(2) % 2 == 0);
        }
        return (!result[i - 1]);
    }
}
