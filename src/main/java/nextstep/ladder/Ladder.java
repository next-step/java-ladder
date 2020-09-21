package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int height, int countOfPerson, Line... lines) {
        return of(height, countOfPerson, Arrays.asList(lines));
    }

    public static Ladder of(int height, int countOfPerson, List<Line> lines) {
        validateHeight(height, lines);
        validateSize(countOfPerson, lines);
        return new Ladder(lines);
    }

    private static void validateHeight(int height, List<Line> lines) {
        if (lines.size() != height) {
            throw new IllegalArgumentException("사다리 높이와 일치하지 않습니다.");
        }
    }

    private static void validateSize(int countOfPerosn, List<Line> lines) {
        Optional<Line> maybeLine = lines.stream()
                .filter(line -> !line.isSameSize(countOfPerosn - 1))
                .findAny();
        if (maybeLine.isPresent()) {
            throw new IllegalArgumentException("Point 개수가 올바르지 않습니다.");
        }
    }
}
