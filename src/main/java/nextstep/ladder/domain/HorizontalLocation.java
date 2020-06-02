package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.LocationLimitExceedException;

import java.util.Objects;

public class HorizontalLocation {
    private static final int MIN_LOCATION_VALUE = 0;

    private final int value;
    private final int countOfPerson;

    public HorizontalLocation(int value, int countOfPerson) {
        validate(value, countOfPerson);
        this.value = value;
        this.countOfPerson = countOfPerson;
    }

    private void validate(int value, int countOfPerson) {
        if (value < MIN_LOCATION_VALUE) {
            throw new LocationLimitExceedException("Location must bigger than 0");
        }
        if (value > countOfPerson) {
            throw new LocationLimitExceedException("Location must smaller than number of people who in ladder game");
        }
    }

    public HorizontalLocation up() {
        return new HorizontalLocation(this.value + 1, this.countOfPerson);
    }

    public HorizontalLocation down() {
        return new HorizontalLocation(this.value - 1, this.countOfPerson);
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorizontalLocation that = (HorizontalLocation) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
