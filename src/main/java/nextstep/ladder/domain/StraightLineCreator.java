package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class StraightLineCreator implements LineCreator {
    @Override
    public Line create(int countOfPerson) {
        List<LineDirection> lineDirections = new ArrayList<>();
        for (int i = 0; i < countOfPerson; i++) {
            lineDirections.add(LineDirection.STRAIGHT);
        }
        return new Line(lineDirections);
    }
}
