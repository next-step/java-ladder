package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import nextstep.ladder.error.exception.LadderHeightSizeException;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int countOfPerson) {
        this(toLines(height, countOfPerson));
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int findUserResult(int userIndex) {
        return lines.stream()
            .reduce(userIndex, this::adjustUserIndex, Integer::sum);
    }

    private int adjustUserIndex(int currentIndex, Line line) {
        if (line.canMoveRight(currentIndex)) {
            return currentIndex + 1;
        }
        if (!line.canMoveRight(currentIndex) && line.canMoveLeft(currentIndex)) {
            return currentIndex - 1;
        }
        return currentIndex;
    }

    private static List<Line> toLines(int height, int countOfPerson) {
        if (height < 1) {
            throw new LadderHeightSizeException(height);
        }

        return Stream.generate(() -> new Line(countOfPerson))
            .limit(height)
            .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

    public int size() {
        return lines.size();

    }
}
