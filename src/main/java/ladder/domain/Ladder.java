package ladder.domain;

import ladder.exception.InvalidLadderException;
import ladder.factory.PointFactory;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_COUNT_OF_LINE = 2;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfLine, int countOfPerson, PointFactory factory) {
        validate(countOfPerson);

        for (int i = 0; i < countOfLine; i++) {
            this.lines.add(new Line(countOfPerson, factory));
        }
    }

    private void validate(int countOfPerson) {
        if (countOfPerson < MIN_COUNT_OF_LINE) {
            throw new InvalidLadderException();
        }
    }

    public List<Line> lines() {
        return this.lines;
    }

}
