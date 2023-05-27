package ladder.domain;

import ladder.domain.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<VerticalLine> verticalLines = new ArrayList<>();

    public Line(int countOfPerson) {
        Random random = new Random();

        Direction lastDirection = Direction.STAY;
        for (int i = 0; i < countOfPerson; i++) {
            if (lastDirection == Direction.RIGHT) {
                verticalLines.add(new VerticalLine(Direction.LEFT));
                lastDirection = Direction.LEFT;
                continue;
            }

            if (i < countOfPerson - 1) {
                lastDirection = Direction.getRightOrStay();
                verticalLines.add(new VerticalLine(lastDirection));
            }
        }
    }
}
