package ladder.domain;

import static ladder.domain.Line.lineOf;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ladder.util.PointStrategy;

public class LadderHeight {

    private static final String TOO_LOW_MSG = "사다리의 높이는 1 이상이여야 합니다.";

    private static final int MIN_LADDER_HEIGHT = 1;

    private final int height;

    public LadderHeight(int height) {
        checkTooShort(height);
        this.height = height;
    }

    public Lines linesByHeight(int countOfPerson, PointStrategy pointStrategy) {
        List<Line> lines = Stream.generate(() -> lineOf(countOfPerson, pointStrategy))
                .limit(this.height)
                .collect(Collectors.toList());
        return new Lines(lines);
    }

    private void checkTooShort(int height) {
        if(height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(TOO_LOW_MSG);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
