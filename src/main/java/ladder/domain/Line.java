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
        Direction direction = Direction.NONE; // 초기값
        for (int i = 0; i < width; i++) {
            direction = Direction.getConnectDirection(direction, i == width - 1);
            verticalLines.add(new VerticalLine(direction));
        }
    }

    public List<VerticalLine> getVerticalLines() {
        return verticalLines;
    }

}
