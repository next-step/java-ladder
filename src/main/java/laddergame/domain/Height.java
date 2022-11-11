package laddergame.domain;

import laddergame.Generator;
import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Height {
    public static final int MINIMUM_OF_HEIGHT = 1;
    private final int height;

    public Height(int height) {
        validateOverMinimum(height);
        this.height = height;
    }

    private void validateOverMinimum(int height) {
        if (height < MINIMUM_OF_HEIGHT) {
            throw new LadderGameException(ErrorCode.HEIGHT_UNDER_MINIMUM);
        }
    }

    public Ladder createLadder(Width width, Generator generator) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> width.createRow(generator))
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height1 = (Height) o;
        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
