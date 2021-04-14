package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import ladder.exception.MinimumLadderHeightException;

public class Ladder {
    private final static int MIN_HEIGHT = 1;

    private final List<LadderLine> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        validate(height);
        create(countOfPerson, height);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new MinimumLadderHeightException("사디리 높이는 최소 1이상이여야 합니다.");
        }
    }

    private void create(int countOfPerson, int height) {
        IntStream.range(0, height)
            .forEach(index -> lines.add(LadderLine.init(countOfPerson)));
    }

    public int ladderHeight() {
        return this.lines.size();
    }
}
