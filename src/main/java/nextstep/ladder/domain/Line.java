package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    public static final int MAX_PERSON_SIZE = 1;
    private final List<Boolean> points;
    private final Random random;

    public Line(List<Boolean> points) {
        this.points = points;
        this.random = new Random();
    }

    public Line (int countOfPerson, Random random) {
        this.random = random;
        if (countOfPerson <= MAX_PERSON_SIZE) {
             throw new IllegalArgumentException(String.format("라인은 %d명 이상인 경우만 생성 됩니다", MAX_PERSON_SIZE));
        }
        this.points = Stream.iterate(random.nextBoolean(), this::hasLine)
                .limit(countOfPerson-MAX_PERSON_SIZE)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean hasLine) {
        return !hasLine && random.nextBoolean();
    }

    public List<Boolean> points() {
        return points;
    }
}
