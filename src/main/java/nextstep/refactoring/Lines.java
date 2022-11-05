package nextstep.refactoring;

import nextstep.refactoring.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(int height, int countOfPerson, BooleanGenerator booleanGenerator) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPerson, booleanGenerator));
        }
    }


    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }
}
