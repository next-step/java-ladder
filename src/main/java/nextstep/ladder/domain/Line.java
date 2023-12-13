package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    public static final int MAX_PERSON_SIZE = 1;
    private final List<Boolean> points;
    public Line(List<Boolean> points) {
        this.points = points;
    }

    public Line (int countOfPerson) {
        if (countOfPerson <= MAX_PERSON_SIZE) {
            throw new IllegalArgumentException(String.format("라인은 %d명 이상인 경우만 생성 됩니다", MAX_PERSON_SIZE));
        }
        this.points = makePoints(countOfPerson);
    }

    public int size() {
        return points.size();
    }

    public int move(int start) {
        boolean leftMovement = start != 0 && points.get(start - 1);
        boolean rightMovement = start != points.size() && points.get(start);

        if (rightMovement) {
            return start+1;
        }

        if (leftMovement) {
            return start-1;
        }

        return start;
    }

    private List<Boolean> makePoints(int count) {
        Random random = new Random();
        return Stream.iterate(random.nextBoolean(), it -> this.hasLine(it, random))
                .limit(count-MAX_PERSON_SIZE)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean hasLine, Random random) {
        return !hasLine && random.nextBoolean();
    }

    public List<Boolean> points() {
        return points;
    }
}
