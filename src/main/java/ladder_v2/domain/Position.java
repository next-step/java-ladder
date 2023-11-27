package ladder_v2.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        if(position<0){
            throw new IllegalArgumentException("Position은 0보다 작을 수 없습니다.");
        }
        this.position = position;
    }

    public Position move(Direction direction){
        if(direction == Direction.RIGHT){
            return new Position(position + 1);
        }
        if(direction == Direction.LEFT){
            return new Position(position - 1);
        }
        return this;
    }

    public int position() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
