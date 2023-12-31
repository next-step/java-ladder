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

    public Line(int countOfPerson) {
        if (countOfPerson <= MAX_PERSON_SIZE) {
            throw new IllegalArgumentException(String.format("라인은 %d명 이상인 경우만 생성 됩니다", MAX_PERSON_SIZE));
        }
        this.points = makePoints(countOfPerson);
    }

    public int size() {
        return points.size();
    }

    public int move(Position position) {
        boolean leftMovement = position.isNotFirstPosition() && points.get(position.leftPosition());
        boolean rightMovement = position.isNotLastPosition() && points.get(position.currentPosition());

        if (rightMovement) {
            return position.rightPosition();
        }

        if (leftMovement) {
            return position.leftPosition();
        }

        return position.currentPosition();
    }


    public int move(PositionMovableStrategy strategy) {
        return strategy.move();
    }

    private List<Boolean> makePoints(int count) {
        Random random = new Random();
        return Stream.iterate(random.nextBoolean(), it -> this.hasLine(it, random))
                .limit(count - MAX_PERSON_SIZE)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean hasLine, Random random) {
        return !hasLine && random.nextBoolean();
    }

    public List<Boolean> points() {
        return points;
    }
}
