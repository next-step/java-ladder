package laddergame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

    private final int position;

    public Position(final int position) {
        if(position < 0){
            throw new IllegalArgumentException("사다리 게임의 위치는 0이상이어야 합니다");
        }
        this.position = position;
    }

    public Position moveLeft(){
        return new Position(position - 1);
    }

    public Position moveRight(){
        return new Position(position + 1);
    }

    public boolean same(int otherPosition) {
        return this.equals(new Position(otherPosition));
    }

    @Override
    public int compareTo(Position other) {
        return Integer.compare(this.position, other.position);
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
        return Objects.hashCode(position);
    }

    public int getPosition() {
        return position;
    }
}
