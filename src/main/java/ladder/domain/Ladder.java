package ladder.domain;

import java.util.List;

import ladder.exception.LadderInvalidException;

public class Ladder {
    private static final int FIRST_INDEX = 0;
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validate(lines);

        this.lines = lines;
    }

    private void validate(List<Line> lines) {
        if (lines.isEmpty()) {
            throw new LadderInvalidException();
        }

        lines.stream()
            .filter(line -> line.getLinks().isEmpty())
            .findAny()
            .ifPresent(line -> {
                throw new LadderInvalidException();
            });
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(FIRST_INDEX).getPoints().size();
    }
}
