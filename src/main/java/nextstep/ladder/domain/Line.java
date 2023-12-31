package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GeneratePointStrategy;
import nextstep.ladder.domain.strategy.PositionMovableStrategy;
import nextstep.ladder.domain.strategy.RandomGeneratePointStrategy;

import java.util.List;

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
        RandomGeneratePointStrategy strategy = new RandomGeneratePointStrategy(countOfPerson);
        this.points = makePoints(strategy);
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

    private List<Boolean> makePoints(GeneratePointStrategy strategy) {
        return strategy.generate();
    }

    public List<Boolean> points() {
        return points;
    }
}
