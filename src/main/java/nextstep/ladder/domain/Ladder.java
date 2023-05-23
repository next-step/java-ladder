package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder (int height, int countOfPerson) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다");
        }
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(countOfPerson))
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> getLines() {
        return lines.stream()
                .map(Line::getPoints)
                .collect(Collectors.toList());
    }
}
