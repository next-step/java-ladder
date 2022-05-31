package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DeduplicationStrategy implements LineStrategy {
    private final static Random RANDOM = new Random();
    private final static int ONE = 1;
    private final static int INITIAL = 0;

    @Override
    public List<Boolean> create(int countOfPerson) {
        List<Boolean> booleans = new ArrayList<>();
        IntStream.range(INITIAL, countOfPerson - ONE)
                .forEachOrdered(index -> booleans.add(deduplicationInsert(booleans, index)));
        booleans.add(false);
        return booleans;
    }

    Boolean deduplicationInsert(List<Boolean> booleans, int index) {
        if (index != INITIAL && booleans.get(index - ONE)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
