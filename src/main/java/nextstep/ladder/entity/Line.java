package nextstep.ladder.entity;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Direction> point;

    public Line(int countOfPerson, int height) {
        this.point = initPoint(countOfPerson, height);
    }

    public Direction getPointIndex(int index){
        return point.get(index);
    }

    // todo 사다리 라인 잘 그려지는지 여부 테스트

    private List<Direction> initPoint(int countOfPerson, int height) {
        List<Direction> initPoint = new ArrayList<>();
        Direction direction = Direction.NONE;
        if(countOfPerson % 2 == 0) {
            direction = Direction.RIGHT;
        }
        initPoint.add(direction);

        for (int i = 1; i < height; i++) {
            if (direction.equals(Direction.RIGHT)) {
               direction = Direction.NONE;
            } else {
                direction = Direction.RIGHT;
            }
            initPoint.add(direction);
        }

        return initPoint;
    }
}
