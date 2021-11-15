package nextstep.ladder.strategy;

import nextstep.ladder.doamin.value.Point;

import java.util.List;

public interface LineStrategy {
    List<Point> createPoints(int countOfPerson);
}
