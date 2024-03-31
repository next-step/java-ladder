package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final LadderHeight height;

    private final List<Line> lines;


    public Ladder(int height, int length, LineGenerator lineGenerator) {
        assertValidDepth(height);

        this.height = new LadderHeight(height);
        this.lines = Stream.generate(() -> new Line(length, lineGenerator))
                .limit(height)
                .collect(Collectors.toUnmodifiableList());
    }

    private void assertValidDepth(int height) {
        String invalidRangeMessage = "[사다리] 사다리 높이는 1 이상이어야 합니다.";
        if (height < 1) {
            throw new IllegalArgumentException(invalidRangeMessage);
        }
    }

    public int getHeight() {
        return height.getHeight();
    }

    public List<Line> getLines() {
        return lines.stream().collect(Collectors.toUnmodifiableList());
    }
}
