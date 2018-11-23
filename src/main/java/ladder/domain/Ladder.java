package ladder.domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private int height;
    private List<Line> lines;

    private Ladder(int height) {
        this.height = height;
        lines = new ArrayList<>();
    }

    public static Ladder from(int height) {
        return new Ladder(height);
    }

    public List<Line> generateLadder(People people, Conditional conditional) {
        for (int i = 0; i < height; i++) {
            lines.add(conditional.test(people));
        }
        return lines;
    }

    public Position calculatePosition(Position position) {
        for (Line line : lines) {
            if(position.isNotEndPosition(line.pointCount()) && isExistRightPoint(position, line)) {
                position.moveRightPosition();
                continue;
            }

            if(position.isNotStartPosition() && isExistLeftPoint(position, line)) {
                position.moveLeftPosition();
                continue;
            }
        }
        return position;
    }

    private static boolean isExistRightPoint(Position position, Line line) {
        return line.isExistPoint(position.rightPosition());
    }

    private static boolean isExistLeftPoint(Position position, Line line) {
        return line.isExistPoint(position.leftPosition());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : lines) {
            stringBuilder.append(line.toString()+"\n");
        }
        return stringBuilder.toString();
    }
}
