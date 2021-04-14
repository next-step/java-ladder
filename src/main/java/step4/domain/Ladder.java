package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import step4.exception.MinimumLadderHeightException;

public class Ladder {
    private final static int MIN_HEIGHT = 1;

    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(List<LadderLine> lines) {
        validate(lines.size());
        return new Ladder(lines);
    }

    public static Ladder of(int countOfPerson, int height) {
        validate(height);
        return new Ladder(create(countOfPerson, height));
    }

    private static void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new MinimumLadderHeightException("사디리 높이는 최소 1이상이여야 합니다.");
        }
    }

    private static List<LadderLine> create(int countOfPerson, int height) {
        List<LadderLine> lines = new ArrayList<>();
        IntStream.range(0, height)
            .forEach(index -> lines.add(LadderLine.init(countOfPerson)));
        return lines;
    }

    public Position play(Position position) {
        for (LadderLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public int ladderHeight() {
        return this.lines.size();
    }
}
