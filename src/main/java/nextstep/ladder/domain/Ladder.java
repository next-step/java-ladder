package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    public static final String LADDER_HEIGHT_ERROR = "사다리 높이는 0보다 커야합니다.";
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        assertLadderHeight(lines.size());
        this.lines = lines;
    }

    public Ladder(int participantCount, int height) {
        List<Line> lines = Stream
                .generate(() -> Line.init(participantCount))
                .limit(height)
                .collect(Collectors.toList());

        assertLadderHeight(lines.size());
        this.lines = lines;
    }

    public int move(int currentPosition) {
        for(Line line : lines) {
            currentPosition = line.move(currentPosition);
        }
        return currentPosition;
    }

    private void assertLadderHeight(int height) {
        if(height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR);
        }
    }

    public List<Line> getValue() {
        return lines;
    }
}
