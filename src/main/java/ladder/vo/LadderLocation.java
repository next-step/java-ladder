package ladder.vo;

import java.util.Objects;

public class LadderLocation {
    private static final int MIN_LOCATION_VALUE = 0;

    private final int index;
    private final int floor;

    public LadderLocation(int index, int floor) {
        validationLocationValue(index, floor);

        this.index = index;
        this.floor = floor;
    }

    private void validationLocationValue(int index, int floor) {
        validationLocationValue(index);
        validationLocationValue(floor);
    }

    private void validationLocationValue(int value) {
        if (value < MIN_LOCATION_VALUE) {
            throw new IllegalArgumentException("Location value must be at least " + MIN_LOCATION_VALUE);
        }
    }

    public boolean isBottom() {
        return (MIN_LOCATION_VALUE == this.floor);
    }

    @Override
    public String toString() {
        return index + "," + floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLocation that = (LadderLocation) o;
        return index == that.index &&
                floor == that.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, floor);
    }
}
