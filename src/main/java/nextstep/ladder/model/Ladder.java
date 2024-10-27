package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfPerson) {
        validateHeight(height);
        validateCountOfPerson(countOfPerson);
        IntStream.range(0, height)
                .forEach(i -> lines.add(new Line(countOfPerson)));
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
}
