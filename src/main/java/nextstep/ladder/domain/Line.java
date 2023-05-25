package nextstep.ladder.domain;

import java.util.List;

public class Line {
    private static final int MINIMUM_COUNT_OF_PERSON = 2;

    private final List<Boolean> points;

    public Line (int countOfPerson) {
        this(countOfPerson, new RandomAmongAllNonAdjacentCombinationLineStrategy());
    }

    public Line (int countOfPerson, LineStrategy lineStrategy) {
        if (countOfPerson < MINIMUM_COUNT_OF_PERSON) {
            throw new IllegalArgumentException("사람은 " + MINIMUM_COUNT_OF_PERSON + "명 이상이어야 합니다");
        }
        this.points = lineStrategy.generate(countOfPerson - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
