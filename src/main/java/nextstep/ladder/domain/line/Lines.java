package nextstep.ladder.domain.line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    public Lines(int userCount, int height, LineCreateStrategy lineCreateStrategy) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }

        this.lines = Stream.generate(() -> new Line(userCount, lineCreateStrategy))
            .limit(height)
            .collect(Collectors.toList());
    }
}
