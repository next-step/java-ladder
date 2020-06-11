package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.LocationLimitExceedException;

import java.util.Objects;

public class HorizontalLocation {
    private static final int MIN_LOCATION_VALUE = 0;

    private final int index;
    private final int maxIndex;

    public HorizontalLocation(int index, int maxIndex) {
        validate(index, maxIndex);
        this.index = index;
        this.maxIndex = maxIndex;
    }

    private void validate(int value, int maxIndex) {
        if (value < MIN_LOCATION_VALUE) {
            throw new LocationLimitExceedException("Location must bigger than 0");
        }
        if (value > maxIndex) {
            throw new LocationLimitExceedException("Location must smaller than number of people who in ladder game");
        }
    }

    public HorizontalLocation moveRight() {
        return new HorizontalLocation(this.index + 1, this.maxIndex);
    }

    public HorizontalLocation moveLeft() {
        return new HorizontalLocation(this.index - 1, this.maxIndex);
    }

    public int parseIndexNumber() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalLocation that = (HorizontalLocation) o;
        return index == that.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public String toString() {
        return "HorizontalLocation{" +
                "index=" + index +
                ", maxIndex=" + maxIndex +
                '}';
    }
}
