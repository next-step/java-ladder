package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class DirectionGenerator {
    private static final int SECOND = 1;
    private static final int FIRST = 1;
    private static final String MINIMUM_USERS = "최소한 1명 이상의 사용자가 있어야합니다.";
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
        return Math.round(Math.random()) < 0.5;
    }

    private int validatePerson(int personCounts) {
        if (personCounts < 2) {
            throw new IllegalArgumentException(MINIMUM_USERS);
        }
        return personCounts;
    }
}
