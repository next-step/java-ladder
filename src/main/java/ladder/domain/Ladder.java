package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import ladder.exception.MinimumLadderHeightException;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private final ConnectStrategy connectStrategy = new RandomConnectStrategy();
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        validate(height);
        create(countOfPerson, height);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new MinimumLadderHeightException("사디리 높이는 최소 1이상이여야 합니다.");
        }
    }

    private void create(int countOfPerson, int height) {
        IntStream.range(0, height)
            .forEach((index -> ladder.add(new Line(countOfPerson, connectStrategy))));
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(this.ladder);
    }

    public LineNumber matchResult(LineNumber lineNumber) {
        for(Line line : ladder) {
            lineNumber = line.matchPoint(lineNumber).getLineNumber();
        }
        return lineNumber;
    }
}
