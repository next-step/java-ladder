package step2.domain;

import step2.exception.ValidPositionException;

import java.util.Objects;

public class PlayerGamePosition {

    private final int position;

    private PlayerGamePosition(final int position) {
        validPosition(position);
        this.position = position;
    }

    public static PlayerGamePosition of(final int position) {
        return new PlayerGamePosition(position);
    }

    private void validPosition(int position) {
        if (position < 0) {
            throw new ValidPositionException();
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerGamePosition that = (PlayerGamePosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
