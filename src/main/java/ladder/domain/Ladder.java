package ladder.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import ladder.exception.LadderInvalidException;

import static java.util.stream.Collectors.toList;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MIN_PERSON_COUNT = 2;

    private final int height;
    private final int width;

    private List<Line> lines;

    public Ladder(int height, int width) {
        validateInput(height, width);

        this.height = height;
        this.width = width;
    }

    private void validateInput(int ladderHeight, int countOfPersons) {
        if (ladderHeight < MIN_HEIGHT || countOfPersons < MIN_PERSON_COUNT) {
            throw new LadderInvalidException();
        }
    }

    public List<Line> getLines() {
        return Optional.ofNullable(lines)
            .orElseGet(() -> lines = createNewLines());
    }

    private List<Line> createNewLines() {
        return IntStream.range(0, height)
            .mapToObj(i -> new Line(width))
            .collect(toList());
    }
}
