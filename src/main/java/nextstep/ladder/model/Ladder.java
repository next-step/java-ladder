package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);
        validateCountOfPerson(countOfPerson);
        lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateCountOfPerson(int countOfPerson) {
        if (countOfPerson < 2) {
            throw new IllegalArgumentException("사다리 인원은 2명 이상이어야 합니다.");
        }
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 0보다 커야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getHeight() {
        return lines.size();
    }
}
