package step2.ladderGame.domain.ladder;


import step2.ladderGame.domain.exception.CountOfUserOutOfBoundsException;
import step2.ladderGame.domain.exception.HeightLowException;
import step2.ladderGame.domain.ladder.pointGenerationStrategy.horizontalLineGenerationStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MIN_COUNT_BY_USER = 2;
    private static final int MIN_HEIGHT = 1;

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfUser, horizontalLineGenerationStrategy horizontalLineGenerationStrategy, int height) {
        validate(countOfUser, height);
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfUser, horizontalLineGenerationStrategy));
        }
    }

    private void validate(int countOfUser, int height) {
        if (countOfUser < MIN_COUNT_BY_USER) {
            throw new CountOfUserOutOfBoundsException();
        }
        if (height < MIN_HEIGHT) {
            throw new HeightLowException();
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
