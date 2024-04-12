package nextstep.ladder.domain;

import java.util.Objects;

public class Position {

    private final int position;

    public Position(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()){
            return false;
        }
        Position position1 = (Position) object;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
