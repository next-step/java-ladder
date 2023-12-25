package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomLineCreator implements LineCreator {
    @Override
    public Line create(int countOfPerson) {
        List<LineDirection> lineDirections = new ArrayList<>();
        lineDirections.add(LineDirection.makeFirstRandomDirection());
        for (int i = 1; i < countOfPerson - 1; i++) {
            lineDirections.add(LineDirection.makeRandomDirection(lineDirections.get(i - 1)));
        }
        lineDirections.add(LineDirection.makeLastDirection(lineDirections.get(countOfPerson - 2)));
        return new Line(lineDirections);
    }
}
