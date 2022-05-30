package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeduplicationStrategy implements Strategy {
    private final static Random RANDOM = new Random();
    private final static int INITIAL = 0;
    private static final int ONE = 1;

    @Override
    public List<Moving> create(int countOfPerson) {
        List<Moving> movings = new ArrayList<>();
        boolean current = RANDOM.nextBoolean();
        Point point = Point.first(current);
        movings.add(new Moving(INITIAL, point));

        for (int i = 1; i < countOfPerson - ONE; i++) {
            current = deduplicationInsert(current);
            point = point.next(current);
            movings.add(new Moving(i, point));
        }
        movings.add(new Moving(countOfPerson - ONE, point.last()));
        return movings;
    }

    private boolean deduplicationInsert(boolean prior) {
        if (prior) {
            return false;
        }
        return RANDOM.nextBoolean();
    }
}
