package nextstep.ladder;

import java.util.Objects;

public class Position {
    public final Natural level;
    public final Natural place;

    public Position(Natural level, Natural place) {
        this.level = level;
        this.place = place;
    }

    public Position(long level, long place) {
        this.level = new Natural(level);
        this.place = new Natural(place);
    }

    public Position getLeftPosition() {
        return new Position(level.value(), place.value() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Position) {
            var that = (Position) o;
            return level.equals(that.level) && place.equals(that.place);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, place);
    }
}
