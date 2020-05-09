package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DirectionGenerator {
    private static final int SECOND = 1;
    private static final int FIRST = 1;
    private static final String MINIMUM_USERS = "최소한 1명 이상의 사용자가 있어야합니다.";
    private static final int MINIMUM_PERSON = 2;
    private static final double FIFTY_PERCENT = 0.5;
    private final int personCounts;

    public DirectionGenerator(final int personCounts) {
        this.personCounts = validatePerson(personCounts);
    }

    public List<Direction> generate() {
        List<Direction> directions = new ArrayList<>();
        Direction index = Direction.first(randomGenerator());
        directions.add(index);
        for (int i = SECOND; i < personCounts - FIRST; i++) {
            index = index.next(randomGenerator());
            directions.add(index);
        }
        directions.add(index.last());
        return directions;
    }

    private Boolean randomGenerator() {
        return new Random().nextBoolean();
    }

    private int validatePerson(int personCounts) {
        if (personCounts < MINIMUM_PERSON) {
            throw new IllegalArgumentException(MINIMUM_USERS);
        }
        return personCounts;
    }
}
