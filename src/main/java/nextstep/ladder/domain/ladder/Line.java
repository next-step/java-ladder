package nextstep.ladder.domain.ladder;

import java.util.List;

import static nextstep.ladder.domain.generator.LineGenerator.assertValidLine;
import static nextstep.ladder.domain.generator.LineGenerator.generateLine;

public class Line {
    private List<Boolean> line;

    public Line(int countOfPeople) {
        this(generateLine(countOfPeople));
    }

    public Line(List<Boolean> values) {
        assertValidLine(values);
        this.line = values;
    }

    public int size() {
        return line.size();
    }

    public List<Boolean> values() {
        return line;
    }

    public boolean canMoveLeft(int index) {
        try {
            if (line.get(index - 1)) { return true; }
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public boolean canMoveRight(int index) {
        try {
            if (line.get(index)) { return true; }
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public int move(int index) {
        if (canMoveLeft(index)) { return index - 1; }
        if (canMoveRight(index)) { return index + 1; }
        return index;
    }
}
