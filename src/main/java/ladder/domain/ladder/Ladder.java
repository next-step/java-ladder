package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private List<Line> lines = new ArrayList<>();

    private Ladder(int height, int countOfPlayers) {
        validate(height);
        createLines(height, countOfPlayers);
    }

    private void createLines(int height, int countOfPlayers) {
        IntStream.range(0, height)
                .forEach(i -> this.lines.add(Line.of(countOfPlayers)));
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_HEIGHT + "이상의 값이어야 합니다.");
        }
    }

    public static Ladder of(int height, int countOfPlayers) {
        return new Ladder(height, countOfPlayers);
    }

    public int getLineSize() {
        return lines.size();
    }

    @Override
    public String toString() {
        return this.lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
