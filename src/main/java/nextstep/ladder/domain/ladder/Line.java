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
}
