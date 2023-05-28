package ladder.domain;

import ladder.domain.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private List<VerticalLine> verticalLines = new ArrayList<>();

    Random random = new Random();

    public Line(int width) {
        for (int i = 0; i < width; i++) {
 //           if (Direction.getRightOrNone().equals(Direction.NONE) || i == width - 1) {\
            if (random.nextBoolean() || i == width - 1) {
                verticalLines.add(new VerticalLine(Direction.NONE));
                continue;
            }

            verticalLines.add(new VerticalLine(Direction.RIGHT));
            verticalLines.add(new VerticalLine(Direction.LEFT));
            i++;
        }
    }

    public List<VerticalLine> getVerticalLines() {
        return verticalLines;
    }

}
